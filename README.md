# aws glue elk
> 此项目服务于 aws glue 的elk


# 项目结构介绍

```

.
├── CHANGELOG.md
├── README.md
├── build.sbt
├── common
├── etl_crawler
├── project
└── target

```

# 仓库加速方式
- 在`~/.sbt` 目录下创建`repositories`文件，并追加如下内容：

```shell
[repositories]
local
osc: http://maven.aliyun.com/nexus/content/groups/public
typesafe: http://repo.typesafe.com/typesafe/ivy-releases/, [organization]/[module]/(scala_[scalaVersion]/)(sbt_[sbtVersion]/)[revision]/[type]s/[artifact](-[classifier]).[ext], bootOnly
sonatype-oss-releases
maven-central
sonatype-oss-snapshots
```
