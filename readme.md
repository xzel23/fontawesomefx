# Fork of [FontAwesomeFX](https://bitbucket.org/Jerady/fontawesomefx)

I forked FontAwesomeFX to create a version that is compatible across different versions of the JDK and fully modularized.

## Changes

All my changes were done on the **9.1.2** branch!

 - replaced the font-size parsing code in `GlyphIconUtils` so that it does not rely on an internal package. This makes it possible to use the same code for different JDK versions.
 
 - changed the gradle build scripts to produce JDK 8 compatible class files, with the exception of the different `module-info.java` files that must be compiled with Java 9 compatibility.
 
 - upgraded the JUnit version to 4.12 because I had build errors with the older 4.10 version.

## Issues resolved

These are issues of the original version that I think should be solved with my changes. If anything doesn't work, please report your problems to me.

- [#27: IllegalAccessError on FontAwesomeIcon construction](https://bitbucket.org/Jerady/fontawesomefx/issues/27/illegalaccesserror-on-fontawesomeicon)

- [#52: IllegalAccessError with Java 9, and used Snapshot 8.4](https://bitbucket.org/Jerady/fontawesomefx/issues/52/illegalaccesserror-with-java-9-and-used)

- [#54: Illegal reflective access with fontawesomefx 9.0.0 (Java 9) when setting size in FXML](https://bitbucket.org/Jerady/fontawesomefx/issues/54/illegal-reflective-access-with)

- [#55: Incompatible with Java 8](https://bitbucket.org/Jerady/fontawesomefx/issues/55/incompatible-with-java-8)

## Using
In build.gradle:

    repositories {
        maven { url  "https://dl.bintray.com/dua3/public" }
    }
    
    dependencies {
        compile 'de.jensd:fontawesomefx-commons:9.1.2-jpms'
    }

## Binaries [ ![Download](https://api.bintray.com/packages/dua3/public/FontAwesomeFX/images/download.svg) ](https://bintray.com/dua3/public/FontAwesomeFX/_latestVersion)

Binaries are available at [bintray](https://bintray.com/dua3/public/FontAwesomeFX).
