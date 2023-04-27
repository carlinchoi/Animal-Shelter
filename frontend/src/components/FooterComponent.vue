<template>
  <div id="q-app">
    <q-layout view="lHh lpr lFf" class="shadow-2 rounded-borders">
      <div class="q-pa-md">
        <div class="content" ref="content">
          <!-- Your page content goes here -->
        </div>
      </div>
      <q-footer v-if="showFooter" bordered class="bg-grey-3 text-primary">
        <q-tabs no-caps active-color="primary" indicator-color="transparent" class="text-grey-8">
          <q-tab name="images" label="Images"></q-tab>
          <q-tab name="videos" label="Videos"></q-tab>
          <q-tab name="articles" label="Articles"></q-tab>
        </q-tabs>
      </q-footer>
    </q-layout>
  </div>
</template>

<script>
import { defineComponent } from 'vue'

export default defineComponent({
  name: 'MyPage',

  data() {
    return {
      showFooter: false,
    }
  },

  mounted() {
    const options = {
      root: null,
      rootMargin: '0px',
      threshold: 1.0,
    }
    const observer = new IntersectionObserver(this.onIntersection, options)
    observer.observe(this.$refs.content)
  },

  methods: {
    onIntersection(entries) {
      const lastEntry = entries[entries.length - 1]
      if (lastEntry.isIntersecting) {
        // show the footer when the bottom of the page is reached
        this.showFooter = true
      } else {
        // hide the footer when the user scrolls back up
        this.showFooter = false
      }
    },
  },
})
</script>
