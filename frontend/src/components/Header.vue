<template>
  <div id="app" style="min-height: 100vh;">
    <q-layout view="lHh lpr lFf"  class="shadow-2 rounded-borders header">
      <q-header class='text-black bg-white' elevated>
        <q-toolbar>
          <q-avatar>
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTet9ewjLhjRL3uQUvKqGCeIdZqreI1Csmxow&usqp=CAU">
          </q-avatar>

          <q-toolbar-title>Rockville Animal Shelter</q-toolbar-title>

          <q-tabs v-model="tab" class="q-tabs-centered">
            <q-tab name="images" label="Home"></q-tab> |
            <q-tab name="videos" label="Our Adopted Pets"></q-tab> |
            <q-tab name="articles" label="Add New Pet Listing" class="q-tab-with-margin"></q-tab>
          </q-tabs>


          <q-btn color="primary" label="Account">
            <q-menu>
              <q-list dense style="min-width: 100px">
                <q-item clickable v-close-popup>
                  <q-item-section>Open...</q-item-section>
                </q-item>
                <q-item clickable v-close-popup>
                  <q-item-section>New</q-item-section>
                </q-item>
                <q-separator></q-separator>
                <q-item clickable>
                  <q-item-section>Preferences</q-item-section>
                </q-item>
              </q-list>
            </q-menu>
          </q-btn>

          <q-menu>
            <q-avatar><img src='https://cdn-icons-png.flaticon.com/512/5087/5087579.png'></q-avatar>
          <q-tab label="Account" class="q-tab-right">
              <q-list>
                <q-item clickable>
                  <q-item-section>
                    Logout
                  </q-item-section>
                </q-item>
              </q-list>
            </q-tab>
          </q-menu>
        </q-toolbar>
      </q-header>

    </q-layout>
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
