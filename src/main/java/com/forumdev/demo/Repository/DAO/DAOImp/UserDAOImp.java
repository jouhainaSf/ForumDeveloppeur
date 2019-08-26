package com.forumdev.demo.Repository.DAO.DAOImp;

import com.forumdev.demo.Model.Comment;
import com.forumdev.demo.Model.Dislike;
import com.forumdev.demo.Model.Like;
import com.forumdev.demo.Model.User;
import com.forumdev.demo.Repository.CommentRepository;
import com.forumdev.demo.Repository.DAO.LikeDAO;
import com.forumdev.demo.Repository.DAO.UserDao;
import com.forumdev.demo.Repository.PostRepository;
import com.forumdev.demo.Repository.UserRepository;
import com.forumdev.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImp implements UserDao {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikeDAO likeDAO;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<User> findAll() {


        List<User> users = userRepository.findAll();
        User user = new User();
        for (int i = 0; i < users.size(); i++) {
            user = afficherUser(users.remove(i));
            users.add(i, user);

        }
        return users;
    }

    @Override
    public ResponseEntity<User> signUp(User user) {

        if (user.getFirstName() == null) {
            logger.error("le champs FirstName est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getLastName() == null) {
            logger.error("le champs LastName  est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getEmail() == null) {
            logger.error("le champs email est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getEmail().indexOf("@gmail.com") == -1) {
            logger.error("your email must contains @gmail.com !");
            return ResponseEntity.notFound().build();
        } else if (!(user.getEmail().endsWith("@gmail.com"))) {
            logger.error("your email must ends with @gmail.com !");
            return ResponseEntity.notFound().build();
        } else if (user.getEmail().length() < 11) {
            logger.error("your email is invalid !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd() == null) {
            logger.error("le champs password est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().length() < 8) {
            logger.error("Mot de passe too short !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().length() > 16) {
            logger.error("Mot de passe too long !");
            return ResponseEntity.notFound().build();
        } else if (this.isPwdValid(user.getPwd()) == false) {
            logger.error("Mot de passe invalid !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().indexOf(user.getFirstName()) != -1) {
            logger.error("Mot de passe ne peut pas contenir votre nom !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().indexOf(user.getLastName()) != -1) {
            logger.error("Mot de passe ne peut pas contenir votre prenom !");
            return ResponseEntity.notFound().build();
        } else if (dejaInscrit(user.getEmail()) != null) {
            logger.error("Cet utilisateur existe deja !");
            return ResponseEntity.notFound().build();
        } else {
            String pwd = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt(12));
            user.setPwd(pwd);
            user.setType("public");
            return ResponseEntity.ok(userRepository.save(user));
        }
    }

    @Override
    public ResponseEntity<String> desabonne(Integer integer) {
        Optional<User> user = userRepository.findById(integer);
        if (user == null) {
            logger.error("Votre compte n'a pas pu etre efface  !");
            return ResponseEntity.notFound().build();
        } else {
            userRepository.deleteById(integer);
            return ResponseEntity.ok("Votre compte a ete bien efface ! ");
        }


    }

    @Override
    public User getUser(Integer integer) {
        return userRepository.findById(integer).get();
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        User user1 = userRepository.findById(user.getId_u()).get();
        if (user.getFirstName() == null) {
            logger.error("le champs FirstName est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getLastName() == null) {
            logger.error("le champs LastName  est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getEmail() == null) {
            logger.error("le champs email est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user1.getEmail().equals(user.getEmail()) == false) {
            logger.error("vous ne pouvez pas changer votre email");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd() == null) {
            logger.error("le champs password est obligatoire prière de le remplir !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().length() < 8) {
            logger.error("Mot de passe too short !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().length() > 16) {
            logger.error("Mot de passe too long !");
            return ResponseEntity.notFound().build();
        } else if (this.isPwdValid(user.getPwd()) == false) {
            logger.error("Mot de passe invalid !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().indexOf(user.getFirstName()) != -1) {
            logger.error("Mot de passe ne peut pas contenir votre nom !");
            return ResponseEntity.notFound().build();
        } else if (user.getPwd().indexOf(user.getLastName()) != -1) {
            logger.error("Mot de passe ne peut pas contenir votre prenom !");
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(userRepository.saveAndFlush(user));
        }
    }

    @Override
    public ResponseEntity<User> logIn(String email, String pwd) {
        if (email == null) {
            logger.error("veuillez saisir votre email !");
            return ResponseEntity.notFound().build();
        } else if (pwd == null) {
            logger.error("veuillez saisir votre mot de passe !");
            return ResponseEntity.notFound().build();
        } else if (userRepository.getUserByEmail(email) == null) {
            logger.error("email incorrect !");
            return ResponseEntity.notFound().build();
        } else {
            String pwd1 = userRepository.getUserByEmail(email).getPwd();
            boolean matched = BCrypt.checkpw(pwd, pwd1);
            if (matched == false) {
                logger.error("pwd incorrect !");
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(afficherUser(userRepository.getUserByEmailAndPwd(email, pwd1)));
        }
    }

    @Override
    public User dejaInscrit(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User afficherUser(User user) {
        User user1 = new User();
        user1.setId_u(user.getId_u());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setType(user.getType());
        return user1;
    }

    @Override
    public List<Like> historiqueLikes(User user) {

        List<Like> likes = userRepository.getLikes(user.getId_u());

        return likes;
    }

    @Override
    public List<Dislike> historiqueDislike(User user) {

        List<Dislike> dislikes = userRepository.getDislikes(user.getId_u());

        return dislikes;
    }

    @Override
    public List<Comment> historiqueComment(User user) {
        return commentRepository.getCommentsByUser(user);
    }

    private boolean isPwdValid(String password) {
        boolean valid = true;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ('a' <= c && c <= 'z')
                if (('a' <= c && c <= 'z') // Checks if it is a lower case letter
                        || ('A' <= c && c <= 'Z') //Checks if it is an upper case letter
                        || ('0' <= c && c <= '9') //Checks to see if it is a digit
                ) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
        }
        return valid;
    }

}

