<template>
  <div id="app">
    <div class="app-head">
      <div class="app-head-inner">
        <!--使用router-link组件来导航，<router-link> 默认会被渲染成一个 `<a>` 标签，通过传入to属性指定链接-->
        <!-- <router-link :to="{path: '/'}">
           <img src="../assets/logo.png">
         </router-link>-->
        <div class="head-nav">
          <ul class="nav-list">
            <li> {{ username }}</li>
            <li v-if="username!== ''" class="nav-pile">|</li>
            <li v-if="username!== ''" @click="quit">退出</li>
            <li v-if="username=== ''" @click="logClick">登录</li>
            <li class="nav-pile">|</li>
            <li v-if="username=== ''" @click="regClick">注册</li>
            <li v-if="username=== ''" class="nav-pile">|</li>
            <li @click="aboutClick">关于</li>
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
      <keep-alive>
        <!-- 路由出口，路由匹配到的组件将渲染在这里 -->
        <layout-center></layout-center>
        <router-view></router-view>
        <!-- <layout-center></layout-center>-->
      </keep-alive>
    </div>
    <div class="app-foot">
      <p>© 2018 Celyur MIT</p>
    </div>
  </div>
</template>

<script>
  import layoutCenter from './components/layoutCenter'

  export default {
    name: 'App',
    components: {
      layoutCenter
    },
    data() {
      return {
        username: ''
      }
    },
    methods: {
      logClick() {
      },
      regClick() {
      },
      aboutClick() {
      },
    }

  }
</script>

<style lang="css">
  @import "../static/css/style.css";
</style>
