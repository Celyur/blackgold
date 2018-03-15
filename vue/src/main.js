// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue' //引入vue
import router from './router'//引入vue路由
import Vuex from "vuex" //引入vue状态管理模块
import Axios from "./axios" //引入axios(引入ajax)
import App from './App' //加载App.vue组件
import ElementUI from 'element-ui' //引入element-ui

// 引入静态资源
// require('./assets/css/style.css')

// 设置 Vue.config.productionTip = false 来关闭生产模式下给出的提示
Vue.config.productionTip = false
// 定义vue路由/状态管理
Vue.use(Vuex)
Vue.use(ElementUI)
// 将axios挂载到Vue原型上方便调用
Vue.prototype.$ajax = Axios
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
  //render:h=>h(App)
})
