A sample environment variables file is `env/variables`

To run with the gradle docker image under power shell:
```batch
docker run --rm -it -v ${pwd}:/home/gradle --env-file env\variables gradle bash
```
Then type in regular gradle commands, like:
```batch
gradle test --tests org.autodatacorp.vindescription.service.*
```

Do similar READMEs for:

- **API repo**: list endpoints covered, tools used, how to run tests.  
- **BDD repo**: show 1–2 `feature` files and how to execute via `pytest-bdd` / `behave`.  
- **Performance repo**: describe JMeter scripts, load model, sample report + your analysis.

Good README = most of the “attractive” feeling.

## 3. Organize folders inside repos

Example for UI framework:

```text
selenium-pytest-automation-framework/
  framework/
    pages/
    utils/
  tests/
    test_login.py
    test_checkout.py
  config/
    config.yaml
  requirements.txt
  conftest.py
  README.md
