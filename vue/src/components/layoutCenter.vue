<template>
  <div class="main_menu">
    <el-menu :default-active="activeIndex" class="el-menu-horizontal-demo" mode="horizontal" unique-opened router>
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index">
            <template slot="title">{{ item.title }}</template>
            <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.index">{{ subItem.title }}
            </el-menu-item>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index">
            {{ item.title }}
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        items: [
          {
            icon: '',
            index: '1',
            title: '宇宙'
          },
          {
            icon: '',
            index: '2',
            title: '国家',
            subs: [
              {
                index: 'China',
                title: '中国'
              },
              {
                index: 'America',
                title: '美国'
              }
            ]
          },
          {
            icon: '',
            index: '3',
            title: '省份',
            subs: [
              {
                index: 'guangdong',
                title: '广东'
              },
              {
                index: 'hunan',
                title: '湖南'
              },
              {
                index: 'zhejiang',
                title: '浙江'
              },
              {
                index: 'shangdong',
                title: '山东'
              }
            ]
          },
          {
            icon: '',
            index: '体育',
            title: '足球'
          },
          {
            icon: '',
            index: '文艺',
            title: '小说'
          }
        ]
      }
    },
    /* computed:{
       onRoutes(){
         return this.$route.path.replace('/','');
       }
     }*/
  }
</script>

<style scoped>
  @import "../../static/css/index.css";

  /* .main_menu>el-submenu{
     width: 240px;
   }*/
  .el-submenu {
    height: 40px;
    line-height: 40px;
    width: 240px;
  }

  .el-menu-item {
    width: 240px;
  }

  .el-menu--horizontal > .el-menu-item {
    height: 40px;
    line-height: 40px;
  }
</style>

