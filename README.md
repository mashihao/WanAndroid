# WanAndroid

### 特讯：新版TODO功能已经上线了，欢迎大家下载体验！！！

[![Platform][1]][2]  [![Build Status][3]][4]  [![Release][5]][6]  [![GitHub license][7]][8]  [![][9]][10]  

[1]:https://img.shields.io/badge/platform-Android-blue.svg  
[2]:https://github.com/iceCola7/WanAndroid

[3]:https://travis-ci.org/iceCola7/WanAndroid.svg?branch=master
[4]:https://travis-ci.org/iceCola7/WanAndroid

[5]:https://img.shields.io/github/release/iceCola7/WanAndroid.svg
[6]:https://github.com/iceCola7/WanAndroid/releases/latest

[7]:https://img.shields.io/badge/license-Apache%202-blue.svg
[8]:https://github.com/iceCola7/WanAndroid/blob/master/LICENSE

[9]:https://img.shields.io/badge/QQ-563859095-orange.svg
[10]:https://github.com/iceCola7/WanAndroid

##### `Github` 地址：[https://github.com/iceCola7/WanAndroid](https://github.com/iceCola7/WanAndroid)
(开源不易，如果喜欢的话希望给个 `Star` 或 `Fork` ^_^ ，谢谢)

## 前言
前段时间学习了 `Kotlin` 的语法知识，然后就写了这个项目熟悉一下 `Kotlin` 语言，总体下来，感觉很爽，相比 `Java` 而言代码行数较少，方法数减少，再加上 `lambda` 语法让代码更加清晰。

`Kotlin` 团队为 `Android` 开发提供了一套超标准语言功能的工具：

- [Kotlin Android 扩展](https://www.kotlincn.net/docs/tutorials/android-plugin.html) 是一个编译器的扩展，可以让你摆脱代码中的 `findViewById` 的调用；
- [Anko](http://github.com/kotlin/anko) 是 `JetBrains` 开发的一个强大的库，它主要的目的是用来替代以前 `XML` 的方式来使用代码生成 `UI` 布局的，它包含了很多的非常有帮助的函数和属性来避免让你写很多的模版代码。

## 简介
[WanAndroid](https://github.com/iceCola7/WanAndroid) 采用 `Kotlin` 语言编写，结合 `MVP` + `RxJava` + `Retrofit` + `Glide` + `EventBus` 等架构设计的项目，项目代码结构清晰并且有详细注释，如有任何疑问和建议请提 `Issue` 或联系 
[![](https://img.shields.io/badge/QQ-563859095-orange.svg)]()，**项目会持续迭代维护，努力打造一款优秀的 [WanAndroid](http://www.wanandroid.com/) 客户端**。

## API
[https://github.com/hongyangAndroid/wanandroid](https://github.com/hongyangAndroid/wanandroid)

## 主要功能
- **首页**：轮播图、文章列表
- **知识体系**：开发环境、基础知识、用户交互等
- **知识体系专题**
- **导航**：常用网站、个人博客、公司博客、开发社区、常用工具等
- **完整项目**
- **登录、注册、注销**
- **收藏**：我的收藏、添加收藏、取消收藏
- **文章内容**
- **搜索**：热门搜索、历史搜索
- **TODO功能**：新增、待办、已完成等功能
- **分享文章**
- **夜间模式**
- **无图模式**
- **自动切换夜间模式**
- **切换主题颜色**
- **清除缓存**
- **关于我们**

## 项目截图
![](art/01.png)
![](art/02.png)
![](art/03.png)
![](art/04.png)

## 主要开源框架
 - [RxJava](https://github.com/ReactiveX/RxJava)
 - [RxAndroid](https://github.com/ReactiveX/RxAndroid)
 - [RxKotlin](https://github.com/ReactiveX/RxKotlin)
 - [Retrofit](https://github.com/square/retrofit)
 - [okhttp](https://github.com/square/okhttp)
 - [Glide](https://github.com/bumptech/glide)
 - [Anko](https://github.com/Kotlin/anko)
 - [moshi-kotlin](https://github.com/square/moshi)
 - [EventBus](https://github.com/greenrobot/EventBus)
 - [BRVH](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)
 - [Logger](https://github.com/orhanobut/logger)
 - [AgentWeb](https://github.com/Justson/AgentWeb)
 - [FlowLayout](https://github.com/hongyangAndroid/FlowLayout)
 - [material-dialogs](https://github.com/afollestad/material-dialogs)
 - [BGABanner-Android](https://github.com/bingoogolapple/BGABanner-Android)
 - [VerticalTabLayout](https://github.com/qstumn/VerticalTabLayout)
 - [leakcanary](https://github.com/square/leakcanary)
 - [litepal](https://github.com/LitePalFramework/LitePal)
 - [Android-Debug-Database](https://github.com/amitshekhariitbhu/Android-Debug-Database)
 - [fab](https://github.com/Clans/FloatingActionButton)
 - [materialdatetimepicker](https://github.com/wdullaer/MaterialDateTimePicker)

## 下载体验

- 点击[![](https://img.shields.io/badge/Download-apk-green.svg)](https://fir.im/wanandroid) 下载

- 扫描下方二维码下载（**二维码，每日上限100次，如果达到上限，还是clone源码吧！**）

	![](./art/qr-code.png)

## 更新日志

**[最新更新日志请点击查看](https://github.com/iceCola7/WanAndroid/releases)**

**v1.0.5**

- 增加TODO功能；
- 增加有无网络的状态提示信息；
- 增加无网切换到有网的重连操作；
- 修改已知 `bug`，如：[#6](https://github.com/iceCola7/WanAndroid/issues/6) 。

**v1.0.3**

- 集成 `bugly` 应用内更新；
- 优化沉浸式状态栏显示效果；
- 优化登录注册界面；
- 修改 `VerticalTabLayout` 的点击 `item` 滑动的问题；
- 优化夜间模式和自动切换夜间模式。

**v1.0.2**

- 优化细节问题；
- 修改已知 `bug` 。

**v1.0.1**

- 增加搜索功能，包含热门搜索和历史搜索；
- 增加 `litepal` 数据库；
- 增加 `bugly` 收集应用异常信息；
- 增加 `Android-Debug-Database` 来查看数据库；
- 修复已知 `bug` 。

**v1.0.0**

- 初始化版本，主要功能都已经完成。

## Thanks

**感谢所有优秀的开源项目 ^_^** 。

## Statement
**项目中的 API 均来自于 [www.wanandroid.com](http://www.wanandroid.com/) 网站，纯属学习交流使用，不得用于商业用途。**

## LICENSE

```
Copyright 2018 iceCola7 

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