# Flutter Module

这是抛砖引玉的示例，实现如何将现有的flutter模块打包成aar引入到其他原生android app内，有没有更好的解决思路？

## 遇到的问题

在flutter开发官网上，有提供[Add Flutter to an existing app](https://docs.flutter.dev/add-to-app)的能力，将flutter用于现有的原生app中，但这种方案使用场景需要满足个条件，是原本app未使用flutter技术，也就是说这个技术方案是为了解决让已有的原生app添加flutter进行混合开发。

但是如果我们需要将flutter功能模块打包成aar用于已经使用了flutter技术的原生app中，上面的方案可行不通了。（网上这块没找到解决方案，查到的都只是上面的场景，难道这种要求是不合理的？）

## 解决的思路

上面的add-to-app方案走不通的主要原因是由于flutter编译产物的冲突导致，参考这个方案通过修改flutter.gradle在编译过程隔离代码和资源的产物和插件的胶水代码，实现自定义的FlutterActivity，修改引擎初始化和flutter加载过程，再结合子进程加载的方式隔离与原本app的影响达到效果。

## 用于实际项目的坑

通过这个思路用于一个现有的复杂app功能中，验证是可行的，但这过程中碰见很多问题需要解决，比如
* 当功能模块直接依赖其他aar文件时，无法生成正常的repo仓库
* 为了让app层的逻辑能复用与独立app和module两种模式，抽取app_lib层进行复用，但是app_lib无法引用flutter和插件代码，需要调整flutter.gradle生成的依赖关系才能像app层那样引用。
* 当使用了像flutter boost的框架时，需要解决引擎共享问题