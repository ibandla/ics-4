# ICS-4 Distributed web objects lab work [![Deploy to now](https://deploy.now.sh/static/button.svg)](https://deploy.now.sh/?repo=https://github.com/ibandla/ics-4/tree/deploy&env=MONGO_URI)

 [![Build Status](https://travis-ci.org/ibandla/ics-4.svg?branch=master)](https://travis-ci.org/ibandla/ics-4) [![](https://img.shields.io/badge/site-live-brightgreen.svg)](https://ics4-2018.now.sh) [![](https://images.microbadger.com/badges/image/ibandla/ics4.svg)](https://microbadger.com/images/ibandla/ics4 "Microbadger image analysis") [![](https://images.microbadger.com/badges/version/ibandla/ics4.svg)](https://hub.docker.com/r/ibandla/ics4 "Get the latest version from dockerhub")

This repo contains the running project for the ICS4 Distributed Web Objects Unit.

## Purpose

To be used to practice consuming a json/xml REST API with feign

## Deploy own version

Click the "Deplot to now" button then fill in the MONGO_URI variable and now token.

## How to get free mongodb

Checkout [mlab](http://mlab.com) and [atlas](https://cloud.mongodb.com)
Then use the mongodb uri that they give it looks like `mongodb://root:password@bar:27017/foo`

## Feign client config

You can use the live version of this project to configure feign

        @FeignClient(url = "https://ics4-2018.now.sh/",name = "ics4feign")
        public interface StudentFeignClient {
        
            @RequestMapping(value = "groups",method = RequestMethod.POST)
            Group createGroup(@RequestBody Group group);
        
            @RequestMapping(value = "{id}/jokes",method = RequestMethod.POST)
            Joke createJoke(@RequestBody Joke joke);
        }
