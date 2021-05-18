# ITF Chartizate modules

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Modules&color=informational)](https://github.com/jesperancinha/itf-chartizate-modules)
[![Maven Central](https://img.shields.io/maven-central/v/org.jesperancinha.itf/itf-chartizate-modules)](https://search.maven.org/search?q=itf.itf-chartizate-modules)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/itf-chartizate-modules.svg)](https://github.com/jesperancinha/itf-chartizate-modules/releases)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a6846d4ad04548919d61b93a97acf27a)](https://www.codacy.com/manual/jofisaes/itf-chartizate-modules?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=JEsperancinhaOrg/itf-chartizate-modules&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/JEsperancinhaOrg/itf-chartizate-modules.svg?style=svg)](https://circleci.com/gh/JEsperancinhaOrg/itf-chartizate-modules)
[![Build Status](https://travis-ci.com/JEsperancinhaOrg/itf-chartizate-modules.svg?branch=master)](https://travis-ci.com/jesperancinha/itf-chartizate-modules)
[![codebeat badge](https://codebeat.co/badges/b35ccc5a-1324-4ad1-a89a-da4edb58b186)](https://codebeat.co/projects/github-com-jesperancinhaorg-itf-chartizate-modules-master)
[![BCH compliance](https://bettercodehub.com/edge/badge/JEsperancinhaOrg/itf-chartizate-modules?branch=master)](https://bettercodehub.com/)
[![codecov](https://codecov.io/gh/jesperancinhaorg/itf-chartizate-modules/branch/master/graph/badge.svg?token=B5py6s5p8j)](https://codecov.io/gh/jesperancinhaorg/itf-chartizate-modules)
[![Coverage Status](https://coveralls.io/repos/github/JEsperancinhaOrg/itf-chartizate-modules/badge.svg?branch=master)](https://coveralls.io/github/JEsperancinhaOrg/itf-chartizate-modules?branch=master)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/itf-chartizate-modules.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/itf-chartizate-modules.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/itf-chartizate-modules.svg)](#)

---
## Description

Implementation modules for the itf-chartizate abstraction for different frameworks
This is an image to char coder, with a spin off to the current available ones
ITF comes from image train filters and the idea is to use this library in many other projects. However the idea was to create a train of filters where each wagon would transform the image. It should work much like the chain of responsibility pattern.

Example:

[![alt text](documentation/testMarket.jpg "Bologna Market Original Image")](https://goo.gl/maps/ujJC9RPnpqA3QG3R9)
[![alt text](documentation/testMarket1.png "Bologna Market Filter Image")](https://goo.gl/maps/ujJC9RPnpqA3QG3R9)
[![alt text](documentation/testMarket2.png "Bologna Market Filter Rd Image")](https://goo.gl/maps/ujJC9RPnpqA3QG3R9)

NOTE: Although [itf-chartizate-java](./itf-chartizate-java/README.md) is built with Java 11, modularization still hasn't been done because [itf-chartizate-api](./itf-chartizate-api/README.md) was built with Java 8.  In turn this had to be done in order to support Android in [itf-chartizate-android](./itf-chartizate-android/README.md).
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
  <version>5.0.1-SNAPSHOT</version>
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

## About me 👨🏽‍💻🚀🏳️‍🌈

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/credly-20.png "Credly")](https://www.credly.com/users/joao-esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED "João Esperancinha Homepage")](https://joaofilipesabinoesperancinha.nl/)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)   
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Webapp&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)   
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)

## Achievements

[![Oracle Certified Professional, JEE 7 Developer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-ee-7-application-developer-100.png "Oracle Certified Professional, JEE7 Developer")](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.credly.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png "Oracle Certified Associate, Java SE 8 Programmer")](https://www.credly.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png "Oracle Certified Associate, Java SE 7 Programmer")](https://www.credly.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225)
[![Oracle Certified Junior Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png "Oracle Certified Foundations Associate")](https://www.credly.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794)
