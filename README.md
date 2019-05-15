# contactform

Příklad ukládání formuláře ContactUs

## Technologie
Spring, Mojarra, Joinfaces, Primefaces, JUnit, Mockito, H2

## Co se může dál řešit
- favicon
- resource bundle (vícejazyčnost)
- logger ve všech třídách
- templatování v JSF
- pokročilejší flow mezi stránkami
- implementace springsecurity
- error pages
- Cascade styles (scss)
- vytvoření executable jar (konfigurace v maven)
- použití JSR303 (validace) - definovat na DTO objektech
- implementace persistentní databáze (zatím použita memory database)
- lepší pokrytí unit testy (zatím pouze ukázka)

## Kompilace
```
mvn clean package
```

## Spuštění serveru
```
mvn spring-boot:run
```

## Zobrazení aplikace
- Pro zobrazení kontaktního formuláře přejděte v prohlížeči na uri: http://localhost:8080
- Pro zobrazení H2 konzole přejděte v prohlížeči na uri: http://localhost:8080/console a nastavte JDBC URL: **jdbc:h2:mem:appdb**
