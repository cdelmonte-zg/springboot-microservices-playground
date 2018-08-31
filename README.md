# springboot-microservices-playground-v2



## Before you start

a) Be sure to have a java 10 JDK installed on your local machine, for ex. executing:
```
java --version
```

b) Verify that maven is also installed.


## To run the infrastructure
1) Set the ENV vars CONFIG_REPO_USERNAME, CONFIG_REPO_PASSWORD, CONFIG_REPO_URI, needed by the configuration service to access the conf data, for example with:

```
export CONFIG_REPO_USERNAME=<username> \
&& export CONFIG_REPO_PASSWORD=<password> \
&& export CONFIG_REPO_URI="<repo URI, for example https://github.com/cdelmonte-zg/config-repo>"
```

2) Start the microservices running from the project root the shell script

```
./runner.sh
```

3) Authenticate over the http://localhost:8901/auth/oauth/token endpoint with a POST verb using the following data: 

+ BasicAuth
Username: cdelmonte
Password: devglan-secret

+ Body: 
grant_type=password
scope=webclient
username=william.gibson
password=password2

4) Use the obtained bearer token to access to the Zuul server and other reosurces


5) Use zipkin ( http://localhost:9411 ) to check if all works.
