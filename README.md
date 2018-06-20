# 介绍
自己在写个人博客的时候，把一些之前学过的，使用过的知识点总结一下。在总结的时候，需要代码练习，那么这个就是当前项目的主要目的。

# 目录
1. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/Cache_demo">cache缓存(原生)</a>
2. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/Json_demo">json解析</a>
3. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/Network_demo">网络请求</a>
4. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/RxAndroid_demo">RxAndroid</a>
5. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/UIDesgin_demo">新增UI组件(desgin)</a>
6. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/StartMode_demo">启动模式</a>
7. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/Permission_demo">权限</a>
8. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/MaterDesgin_demo">materdesgin</a>
9. 设计模式

10. <a href="https://github.com/xiaoniudadi/blog_demo_android/tree/master/SelfUI_demo">自定义View</a>
11. <a href="http://github.com/xiaoniudadi/blog_demo_android/tree/master/JNI_Demo">JNI编程</a>
12. <a href="http://gitub.com/xiaoniudadi/blog_demo_android/tree/master/FileShare_demo">android分享文件</a>

## cache

<a href="http://www.paulniu.com/2016/04/15/android-6-cache/">重拾android路(六) 缓存</a>

## json解析

<a href="http://www.paulniu.com/2016/02/29/android-4-json/">重拾Android路(四) json解析</a>

## 网络请求

网络请求是我们的手机应用中最常用的模块，手机应用对于网络请求的优劣直接决定了用户的体验。这里我们介绍了三种最常见也是在android开发历史中比较重要的三个框架。

原生HttpClientRequest:这种网络请求是比较简单的网络请求，也是google公司最原始封装的网络请求框架，能够进行简单的网络请求，方面上手，对于新手而言是非常实用的学习基础。但是他的缺点也是显而易见的，对于请求框架封装的不太完善，而且由于android的机制要求在UI线程中刷新页面，导致我们需要大量的使用handler，那么有时候，我们会发生一些逻辑错误，而这些逻辑错误也是非常致命的。

OKHttp:这种网络请求框架是google公司推荐和提倡使用的框架。不仅解决了handler大量使用的问题(因为在这里他帮我们将数据请求等内容进行了封装)，而且配合使用gilde的图片请求框架也是非常好用的

Retrofit：目前最流行的网络请求框架。他是基于OKHttp网络请求框架的，所以在使用的时候，我们需要把相应的OKHttp的gradle依赖也添加进来。目前很多地方都在提倡使用数据绑定和异步操作的rxjava和rxAndroid，配合使用retrofit也可以很好的上手。

至于具体的优缺点和如何使用博客中已经详细记载

使用的版本均是最新版本，其中OKHttp必须是3.0以上，retrofit是2.0以上。rxjava和rxandroid可以使用1.x或者2.x，这里介绍的都是比较简单的，所以具体操作不影响

<a href="https://github.com/square/retrofit">Retrofit</a><br/>
<a href="https://github.com/square/okhttp">OKHttp</a>

<a href="http://www.paulniu.com/2016/02/19/Android-3-network/">重拾android路(三) 网络请求</a>

## RxAndroid

<a href="http://www.paulniu.com/2016/03/23/android-5-rejava/">重拾Android路(五) RxJava和RxAndroid</a>

## UIDesgin

<a href="http://www.paulniu.com/2016/05/15/android-8-uiframework/">重拾android路(八) UI</a> 

## 启动模式

<a href="http://www.paulniu.com/2016/08/28/android-14-start-mode/">重拾android路(十四) 启动模式</a> 

## 权限

<a href="http://www.paulniu.com/2016/08/05/android-13-permission/">重拾android路(十三) 权限</a>

## materdesgin

<a href="http://www.paulniu.com/2016/07/20/android-12-materialdesign/">重拾android路(十二) material design</a> 

## 自定义View


## JNI 编程
<a href="http://www.paulniu.com/2018/06/12/android-jni">重拾Android路 JNI编程</a>

## Android分享
关于Android的分享，我相信大家都有接触过，特别是对于一些特殊的应用，比如网上商城，我们经常通过这样的分享操作，把我们看到比较喜欢的物品分享给我们的朋友。
那么我们的分享其实不仅仅是分享一个链接，一个图片，有时候我们还会分享一个视频，分享一个文件，那么这些都是我们的手机需要执行的操作。这个例子中包含两个部分
- 利用第三方分享集成，例如友盟等
- 自定义实现，通过Android中的intent，帮我们实现
<a href="http://www.paulniu.com/2018/06/20/share">重拾Android路 Android分享</a>


> 以梦为码，不负韶华

> <a href="http://www.paulniu.com">个人博客</a>
