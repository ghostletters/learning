## Created Project

From https://quarkus.io/guides/rest-json

```bash
mvn io.quarkus:quarkus-maven-plugin:1.12.2.Final:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=realworld-fulltext-search \
    -DclassName="org.acme.rest.json.PersonResource" \
    -Dpath="/person" 
```