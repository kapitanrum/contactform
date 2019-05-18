# contactform

Příklad ukládání formuláře ContactUs

## Technologie
Spring, Mojarra, Joinfaces, Primefaces, JUnit, Mockito, H2

## Co se může dál řešit
- Logger - detailnější logování
- Templatování v JSF
- Pokročilejší flow mezi stránkami
- Implementace springsecurity
- Error pages
- Cascade styles (scss)
- Implementace persistentní databáze (zatím použita memory database)
- Lepší pokrytí unit testy (zlepšeno + jednoduchý integrační test)
- Použití object mapping frameworku

## Kompilace
```
mvn clean package
```

## Spuštění serveru
```
mvn spring-boot:run
```
nebo
```
java -jar contact-form-1.0.0-SNAPSHOT.jar
```


## Zobrazení aplikace
- Pro zobrazení kontaktního formuláře přejděte v prohlížeči na uri: http://localhost:8080
- Pro zobrazení H2 konzole přejděte v prohlížeči na uri: http://localhost:8080/console a nastavte JDBC URL: **jdbc:h2:mem:appdb**
