<template>
  <div class="home-text-container">
    <div class="home-title-container">
      <h1 style ='font-weight:bold'>
        Every Pet Deserves a Loving Home. <br>
        <span style='color:orange'>Adopt </span>
        <span>a Pet Today!</span>
      </h1>
      <p>
        Browse our available animals and learn more about the adoption process. Together, we can
        <span style='font-weight: bold;'> rescue, rehabilitate, and rehome pets in need.</span>
        Thank you for supporting our mission to bring joy to families through pet adoption!
      </p>
      <q-separator color="black" thickness="1px" style="height: 2px" />
    </div>
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue'
name: "HomeText"
const linksList = [
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
]

export default defineComponent({
  name: 'MainLayout',

  components: {
  },

  setup () {
    const leftDrawerOpen = ref(false)

    return {
      essentialLinks: linksList,
      leftDrawerOpen,
      toggleLeftDrawer () {
        leftDrawerOpen.value = !leftDrawerOpen.value
      }
    }
  }
})
</script>
