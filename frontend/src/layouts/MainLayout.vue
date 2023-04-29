<template >
  <q-layout view="hHh lpr fFf" >
    <AppHeader />

    <q-page-container @scroll="onScroll">
      <Home />
      <PetSearch />
    </q-page-container>
    <AppFooter />
  </q-layout>


</template>

<script>

import Home from '../components/Home.vue'
import PetSearch from 'src/components/PetSearch.vue'
import { debounce } from 'lodash'
import AppFooter from '../components/AppFooter.vue'
import AppHeader from '../components/AppHeader.vue'

export default {
  name: 'MainLayout',
  components: {
    Home,
    PetSearch,
    AppFooter,
    AppHeader
  },
  data () {
    return {
      showFooter: false,
      linksList: [
        {
          title: 'Docs',
          caption: 'quasar.dev',
          icon: 'school',
          link: 'https://quasar.dev'
        },
        {
          title: 'Github',
          caption: 'github.com/quasarframework',
          icon: 'code',
          link: 'https://github.com/quasarframework'
        },
        {
          title: 'Discord Chat Channel',
          caption: 'chat.quasar.dev',
          icon: 'chat',
          link: 'https://chat.quasar.dev'
        },
        {
          title: 'Forum',
          caption: 'forum.quasar.dev',
          icon: 'record_voice_over',
          link: 'https://forum.quasar.dev'
        },
        {
          title: 'Twitter',
          caption: '@quasarframework',
          icon: 'rss_feed',
          link: 'https://twitter.quasar.dev'
        },
        {
          title: 'Facebook',
          caption: '@QuasarFramework',
          icon: 'public',
          link: 'https://facebook.quasar.dev'
        },
        {
          title: 'Quasar Awesome',
          caption: 'Community Quasar projects',
          icon: 'favorite',
          link: 'https://awesome.quasar.dev'
        }
      ],
      leftDrawerOpen: false
    }
  },
  methods: {
    handleScroll() {
      // Check if the user has scrolled to the bottom of the page
      if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
        this.showFooter = true
      } else {
        this.showFooter = false
      }
    }
  },
  mounted() {
    window.addEventListener('scroll', debounce(this.handleScroll, 200))
  },
  beforeUnmount() {
    window.removeEventListener('scroll', this.handleScroll)
  }
}
</script>
