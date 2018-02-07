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


> 以梦为码，不负韶华

> <a href="http://www.paulniu.com">个人博客</a>
