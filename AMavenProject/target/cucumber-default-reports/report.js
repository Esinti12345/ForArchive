$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AddCourse.feature");
formatter.feature({
  "name": "Add Course",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I logged in into OrangeHrm to add a course",
  "keyword": "Given "
});
formatter.match({
  "location": "AddCourseSteps.i_logged_in_into_OrangeHrm_to_add_a_course()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Training link",
  "keyword": "And "
});
formatter.match({
  "location": "AddCourseSteps.i_click_on_Training_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Courses link",
  "keyword": "And "
});
formatter.match({
  "location": "AddCourseSteps.i_click_on_Courses_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Add Course button",
  "keyword": "And "
});
formatter.match({
  "location": "AddCourseSteps.i_click_on_Add_Course_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add Course from map",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@temp"
    }
  ]
});
formatter.step({
  "name": "I provide CourseTitle and Coordinator from below",
  "rows": [
    {
      "cells": [
        "CourseTitle",
        "Coordinator"
      ]
    },
    {
      "cells": [
        "Science",
        "j"
      ]
    },
    {
      "cells": [
        "Social Studies",
        "d"
      ]
    },
    {
      "cells": [
        "ELA",
        "r"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "AddCourseSteps.i_provide_CourseTitle_and_Coordinator_from_below(DataTable)"
});
formatter.result({
  "error_message": "org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element \u003cspan class\u003d\"left-menu-title\"\u003e...\u003c/span\u003e is not clickable at point (94, 503). Other element would receive the click: \u003cdiv class\u003d\"overlay-layer\" id\u003d\"background-screen\"\u003e\u003c/div\u003e\n  (Session info: chrome\u003d75.0.3770.100)\n  (Driver info: chromedriver\u003d74.0.3729.6 (255758eccf3d244491b8a1317aa76e1ce10d57e9-refs/branch-heads/3729@{#29}),platform\u003dMac OS X 10.14.5 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Ahmets-MBP.home\u0027, ip: \u0027fe80:0:0:0:43d:e3a3:4be7:a499%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.14.5\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 74.0.3729.6 (255758eccf3d24..., userDataDir: /var/folders/hm/qhgmwbfs3qq...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:63864}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 75.0.3770.100, webStorageEnabled: true}\nSession ID: 21b9de9422b056295beae9107cafed99\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\n\tat com.sun.proxy.$Proxy16.click(Unknown Source)\n\tat com.secondMaven.steps.AddCourseSteps.i_provide_CourseTitle_and_Coordinator_from_below(AddCourseSteps.java:98)\n\tat ✽.I provide CourseTitle and Coordinator from below(file:src/test/resources/features/AddCourse.feature:36)\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});