package com.jiahanglee.babyship.theone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @GetMapping(value = "/get")
    public List<Girl> getGirl() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/save")
    public Girl save(
            @RequestParam("cupSize") String cupSize,
            @RequestParam("age") Integer age
            ) {
                    Girl girl = new Girl();
                    girl.setAge(age);
                    girl.setCupSize(cupSize);

                  return   girlRepository.save(girl);
    }

    @GetMapping(value = "/geta/{id}")
    public Girl geta(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }
    @PutMapping(value = "/update/{id}")
    public Girl update(@PathVariable("id") Integer id,
                       @RequestParam("cupSize") String cupSize,
                       @RequestParam("age") Integer age
                       ){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }
    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        girlRepository.delete(girlRepository.findById(id).get());
    }

    @GetMapping(value = "/getb/{age}")
    public List<Girl> getb(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }
}
