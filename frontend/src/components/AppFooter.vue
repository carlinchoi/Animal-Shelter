<template>
  <q-footer v-if="showFooter" bordered class="text-white" color="primary">
    <q-tabs no-caps active-color="orange" indicator-color="orange" class="text-white">
      <q-tab name="Home" label="Home" style="font-weight: bold; font-size: 1.5em">
        <router-link :to="{ name: 'homePage' }">Home</router-link>
      </q-tab>
      <q-tab name="FAQ" label="FAQ" style="font-weight: bold; font-size: 1.5em">
        <router-link :to="{ name: 'faqPage' }">FAQ</router-link>
      </q-tab>
      <q-tab name="articles" label="Articles" style="font-weight: bold; font-size: 1.5em"></q-tab>
    </q-tabs>
  </q-footer>
</template>


<script>
import { debounce } from 'lodash'

export default {
  name: 'AppFooter',
  data() {
    return {
      showFooter: false
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
  beforeUnmounted() {
    window.removeEventListener('scroll', debounce(this.handleScroll, 200))
  }
}
</script>
