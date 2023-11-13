package br.edu.ifpb.pdist.back.controller;

import br.edu.ifpb.pdist.back.model.User;
import br.edu.ifpb.pdist.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository; 

    // Rota para cadastrar um Usuário no Sitema
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user, RedirectAttributes redAttrs) {
        Optional<User> OpUser = userRepository.findByUsername(user.getUsername());
        if (!OpUser.isPresent()){       
            User novoUser = userRepository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUser); 
        }
        return null;
    }

    // Rota para atualizar um Usuário pelo formUpUser
    @RequestMapping(value="/logar", method = RequestMethod.POST)
    public ResponseEntity<User> login( @RequestParam("param1") String username, @RequestParam("param2") String password, RedirectAttributes redAttrs) {
      System.err.println("mostra&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+username+ password);
        Optional<User> usuarioLogado = userRepository.findByUsername(username);
        if (usuarioLogado.isPresent()) {
             System.err.println("Entrei&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+username+ password);
            User usu = usuarioLogado.get();
            if(usu.getPassword().equals(password)){
                return ResponseEntity.status(HttpStatus.OK).body(usu);
            }
            
        } 
            return null;
         
    }

    // Rota para deletar um Usuário
    // @RequestMapping("/delete/{id}")
    // public void excluirUser(@PathVariable(value = "id") Integer id) {
    //     Optional<User> OpUser = userRepository.findById(id);
    //     if (OpUser.isPresent()){
    //         User user = OpUser.get();
    //         userRepository.delete(user);
    //     }
    // }
}
