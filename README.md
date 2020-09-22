A sample environment variables file is `env/variables`

To run with the gradle docker image under power shell:
```batch
docker run --rm -it -v ${pwd}:/home/gradle --env-file env\variables gradle bash
```
Then type in regular gradle commands, like:
```batch
gradle test --tests org.autodatacorp.vindescription.service.*
```
