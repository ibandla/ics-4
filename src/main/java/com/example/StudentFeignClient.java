package com.example;

import com.example.domain.Group;
import com.example.domain.Joke;
import com.example.models.Me;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Elphas Khajira on 9/20/17.
 */
@FeignClient(url = "https://qnsnwbtpxq.localtunnel.me",name = "yi")
public interface StudentFeignClient {

    @RequestMapping(value = "students",method = RequestMethod.POST)
    Me createMe(@RequestBody Me me);

    @RequestMapping(value = "students/{id}/calculate?operation={operation}", method = RequestMethod.POST)
    Double calculate(@RequestBody List<Double> l, @PathVariable("id") String id, @PathVariable("operation") String operation);

    @RequestMapping(value = "students/{id}/validate?result={answer}",method = RequestMethod.POST)
    Void validate(@RequestBody List<Double> l, @PathVariable("id") String id, @PathVariable("answer") Double answer);

    @RequestMapping(value = "groups",method = RequestMethod.POST)
    Group createGroup(@RequestBody Group group);

    @RequestMapping(value = "groups/{id}/jokes",method = RequestMethod.POST)
    Joke createJoke(@RequestBody Joke joke, @PathVariable("id") String id);
}
