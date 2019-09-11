# ITF Chartizate modules

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Modules&color=informational)](https://github.com/jesperancinha/itf-chartizate-modules)
[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.itf/itf-chartizate-modules)](https://search.maven.org/search?q=itf.itf-chartizate-modules)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/itf-chartizate-modules.svg)](https://github.com/jesperancinha/itf-chartizate-modules/releases)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/02c2cdb0fecb4c1b84f70b214d020f80)](https://www.codacy.com/manual/jofisaes/itf-chartizate-modules?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/itf-chartizate-modules&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/jesperancinha/itf-chartizate-modules.svg?style=svg)](https://circleci.com/gh/jesperancinha/itf-chartizate-modules)
[![Build Status](https://travis-ci.org/jesperancinha/itf-chartizate-modules.svg?branch=master)](https://travis-ci.org/jesperancinha/itf-chartizate-modules)
[![codebeat badge](https://codebeat.co/badges/38f795d1-c092-4aac-976d-ec193651cd49)](https://codebeat.co/projects/github-com-jesperancinha-itf-chartizate-modules-master)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/itf-chartizate-modules?branch=master)](https://bettercodehub.com/)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/itf-chartizate-modules.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/itf-chartizate-modules.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/itf-chartizate-modules.svg)](#)

---
## Description

Implementation modules for the itf-chartizate abstraction for different frameworks
This is an image to char coder, with a spin off to the current available ones
ITF comes from image train filters and the idea is to use this library in many other projects. However the idea was to create a train of filters where each wagon would transform the image. It should work much like the chain of responsibility pattern.

Example:  
From: <img src="https://raw.githubusercontent.com/jesperancinha/itf-chartizate/master/itf-chartizate-android/itf-chartizate-android/src/main/res/raw/realexample1.jpg" alt="" data-canonical-src="https://raw.githubushttps://raw.githubusercontent.com/jesperancinha/itf-chartizate/master/itf-chartizate-android/src/main/res/raw/realexample1.jpg" width="250" height="250" /> 
To:
<img src="https://raw.githubusercontent.com/jesperancinha/itf-chartizate/master/itf-chartizate-android/itf-chartizate-android/src/main/res/raw/realexample1_expected.png" alt="" data-canonical-src="https://raw.githubushttps://raw.githubusercontent.com/jesperancinha/itf-chartizate/master/itf-chartizate-android/src/main/res/raw/realexample1expected.png" width="250" height="250" />

NOTE: Although [itf-chartizate-java](./itf-chartizate-java/README.md) is built with Java 11, modularization still hasn't been done because [itf-chartizate-api](./itf-chartizate-api/README.md) was built with Java 8. In turn this had to be done in order to support Android in [itf-chartizate-android](./itf-chartizate-android/README.md).
## Tools

$ git push --delete origin 2.0.0  
$ git tag --delete 2.0.0

```text
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys <your GPG key>
gpg --list-keys
export GPG_TTY=$(tty)
mvn clean deploy -Prelease
mvn nexus-staging:release  -Prelease
```

## Maven

```xml
<dependency>
  <groupId>org.jesperancinha.itf</groupId>
  <artifactId>itf-chartizate-modules</artifactId>
  <version>?</version>
  <type>pom</type>
</dependency>
```

## References

-   [Definitive Guide To Java 12](https://blog.codefx.org/java/java-12-guide/)
-   [Publish AAR to jCenter and Maven Central](https://gist.github.com/lopspower/6f62fe1492726d848d6d)
-   [Publishing Android Library to Bintray with Gradle + Buddy.Works](https://medium.com/camerakit/publishing-android-library-to-bintray-with-gradle-buddy-works-dd50cbd03df5)
-   [How to distribute your own Android library through jCenter and Maven Central from Android Studio](https://inthecheesefactory.com/blog/how-to-upload-library-to-jcenter-maven-central-as-dependency/en)
-   [Creating .asc signature files with GPG](http://www.benmccann.com/creating-asc-signature-files-with-gpg/)
-   [Publish java library to JFrog Bintray and OSS Sonatype with Gradle](https://medium.com/@rosolko/publish-java-library-to-jfrog-bintray-and-sonatype-with-gradle-1a3ebd5b8be8)
-   [Enjoy Bintray and use it as pain-free gateway to Maven Central](https://blog.bintray.com/2014/02/11/bintray-as-pain-free-gateway-to-maven-central/)
-   [Android Library Publishing Maven Artifacts via gradle](https://gist.github.com/danielesegato/3ea6f99c968ce0b795c5390844ad4ff7)
-   [Gradle generate javadoc for Android](https://gist.github.com/kibotu/994c9cc65fe623b76b76fedfac74b34b)
-   [A Complete Guide to Create and Publish an Android Library to Maven Central](https://medium.com/@zubairehman.work/a-complete-guide-to-create-and-publish-an-android-library-to-maven-central-6eef186a42f5)
-   [Publish a Java Project to Maven Central with Gradle](http://weibeld.net/java/publish-to-maven-central.html)
-   [Sign and publish on Maven Central a Project with the new maven-publish Gradle plugin](https://medium.com/@nmauti/sign-and-publish-on-maven-central-a-project-with-the-new-maven-publish-gradle-plugin-22a72a4bfd4b)
-   [How to Upload an Open-Source Java Library to Maven Central](https://www.freecodecamp.org/news/how-to-upload-an-open-source-java-library-to-maven-central-cac7ce2f57c/)
-   [Nexus Sonatype](https://oss.sonatype.org/#welcome)
-   [Working with PGP Signatures](https://central.sonatype.org/pages/working-with-pgp-signatures.html)

---
---

### Deprecated

The following are libraries available in JFrog. I am not maintaining them anymore because of the major refactoring I had to do to support my other project [Image train filters](https://github.com/jesperancinha/image-train-filters-scala). You can find the releases in this repo and also in JFrog. The coming versions will be more stable and thought out to the general public.

## chartizate-text-writer-api

[![Download](https://api.bintray.com/packages/jesperancinha/maven/itf-chartizate-java/images/download.svg?version=1.1.4)](https://bintray.com/jesperancinha/maven/itf-chartizate-java/1.1.4/link) 
[![Download](https://api.bintray.com/packages/jesperancinha/itf/itf-chartizate-api/images/download.svg)](https://bintray.com/jesperancinha/itf/itf-chartizate-api/_latestVersion)  


## chartizate-text-writer-android

[![Download](https://api.bintray.com/packages/jesperancinha/maven/itf-chartizate-android/images/download.svg?version=1.1.4)](https://bintray.com/jesperancinha/maven/itf-chartizate-android/1.1.4/link)
[![Download](https://api.bintray.com/packages/jesperancinha/itf/itf-chartizate-java/images/download.svg)](https://bintray.com/jesperancinha/itf/itf-chartizate-java/_latestVersion)
---

## License

```text
Copyright 2016-2019 João Esperancinha (jesperancinha)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## About me

-   [![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=informational)](http://joaofilipesabinoesperancinha.nl)

-   [![Twitter Follow](https://img.shields.io/twitter/follow/jofisaes.svg?label=%40jofisaes&style=social)](https://twitter.com/intent/follow?screen_name=jofisaes)

-   [![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social)](https://github.com/jesperancinha)

-   Free Code Camp [jofisaes](https://www.freecodecamp.org/jofisaes)

-   Hackerrank [jofisaes](https://www.hackerrank.com/jofisaes)

-   Acclaim Badges [joao-esperancinha](https://www.youracclaim.com/users/joao-esperancinha/badges)

-   Projects:

    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=informational)](http://tds.joaofilipesabinoesperancinha.nl/)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=informational)](http://itf.joaofilipesabinoesperancinha.nl/)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=informational)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=Google%20Apps&message=Joao+Filipe+Sabino+Esperancinha&color=informational)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)

-   Releases:
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=informational)](https://github.com/jesperancinha/itf-chartizate/tree/master/itf-chartizate-android)[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.itf/itf-chartizate-android)](https://search.maven.org/search?q=itf.itf-chartizate-android)[![Download](https://api.bintray.com/packages/jesperancinha/maven/itf-chartizate-android/images/download.svg)](https://bintray.com/jesperancinha/maven/itf-chartizate-android/_latestVersion)[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/itf-chartizate.svg)](https://github.com/jesperancinha/itf-chartizate/releases)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=informational)](https://github.com/jesperancinha/itf-chartizate/tree/master/itf-chartizate-java)[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.itf/itf-chartizate-java)](https://search.maven.org/search?q=itf.itf-chartizate-java)[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/itf-chartizate.svg)](https://github.com/jesperancinha/itf-chartizate/releases)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=informational)](https://github.com/jesperancinha/itf-chartizate/tree/master/itf-chartizate-api)[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.itf/itf-chartizate-api)](https://search.maven.org/search?q=itf.itf-chartizate-api)[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/itf-chartizate.svg)](https://github.com/jesperancinha/itf-chartizate/releases)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=informational)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.parser/markdowner-core)](https://search.maven.org/search?q=parser.markdowner-core)[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/markdowner.svg)](https://github.com/jesperancinha/markdowner/releases)
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=informational)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.parser/markdowner-filter)](https://search.maven.org/search?q=parser.markdowner-filter)[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/markdowner.svg)](https://github.com/jesperancinha/markdowner/releases)

-   Status page:
    -   [![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Project%20Status&color=informational)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
