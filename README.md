# springboot-microservices-playground-v2


1) Set the ENV vars CONFIG_REPO_USERNAME, CONFIG_REPO_PASSWORD, CONFIG_REPO_URI, needed by the configuration service to access the conf data, for example with:

```
export CONFIG_REPO_USERNAME=<whatever username>\
&& export CONFIG_REPO_PASSWORD=<whatever password> \
&& export CONFIG_REPO_URI="<whatever repo URI>"
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


5) check on zipkin if all works
http://localhost:9411
