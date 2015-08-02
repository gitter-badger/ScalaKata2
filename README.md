# ScalaKata

[![Travis Build Status](https://img.shields.io/travis/MasseGuillaume/ScalaKata2.svg?style=flat-square)](https://travis-ci.org/MasseGuillaume/ScalaKata2) [![Windows Build status](https://img.shields.io/appveyor/ci/MasseGuillaume/ScalaKata2.svg?style=flat-square)](https://ci.appveyor.com/project/MasseGuillaume/scalakata2/branch/master) [![Chat on Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/MasseGuillaume/ScalaKata2)

## Distributions

### Sbt Plugin

Add the following lines to `project/plugins.sbt`

```
resolvers += Resolver.url("masseguillaume/sbt-plugins", url("http://dl.bintray.com/masseguillaume/sbt-plugins/"))(Resolver.ivyStylePatterns)
addSbtPlugin("com.scalakata" % "sbt-scalakata" % "1.0.3")
```

### Docker containers

`sudo docker run -p 7331:7331 --name scalakata masseguillaume/scala:1.0.3`

or

`sudo docker run -p 7331:7331 --name scalakata masseguillaume/scala-bundle:1.0.3`

open your browser at `http://localhost:7331`

