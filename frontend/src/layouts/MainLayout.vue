<template>
  <q-layout view="hHh lpr fFf">

    <q-header class="text-black bg-white" elevated style="overflow-x: hidden;">
        <q-toolbar>
          <q-avatar>
            <img
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTet9ewjLhjRL3uQUvKqGCeIdZqreI1Csmxow&usqp=CAU"
            />
          </q-avatar>

          <q-toolbar-title>Rockville Animal Shelter</q-toolbar-title>

          <q-tabs v-model="tab" class="q-tabs-centered">
            <q-tab name="images" label="Home"></q-tab> |
            <q-tab name="videos" label="Our Adopted Pets"></q-tab> |
            <q-tab name="articles" label="Add New Pet Listing"></q-tab> |
            <q-tab
              name="articles"
              label="Become a Volunteer"
              class="q-tab-with-margin"
            ></q-tab>
          </q-tabs>

          <q-btn color="primary" label="Account">
            <q-menu>
              <q-list dense style="min-width: 100px">
                <q-item clickable v-close-popup>
                  <q-item-section>View Volunteers</q-item-section>
                </q-item>
                <q-item clickable v-close-popup>
                  <q-item-section>Approve Pending Volunteers</q-item-section>
                </q-item>
                <q-separator></q-separator>
                <q-item clickable>
                  <q-item-section>Log Out</q-item-section>
                </q-item>
              </q-list>
            </q-menu>
          </q-btn>
        </q-toolbar>
      </q-header>

    <q-page-container @scroll="onScroll">
      <Home />
      <PetSearch />
    </q-page-container>

<!-- eslint-disable-next-line vue/no-deprecated-v-on-native-modifier -->
<q-footer v-if="showFooter" bordered class="text-white" color="primary" height="100px">
  <q-tabs no-caps active-color="primary" indicator-color="transparent" class="text-white">
    <q-tab name="images" label="Images" style="font-weight: bold; font-size: 16px" ></q-tab>
    <q-tab name="videos" label="Videos" style="font-weight: bold; font-size: 16px"></q-tab>
    <q-tab name="articles" label="Articles" style="font-weight: bold; font-size: 16px"></q-tab>
  </q-tabs>
</q-footer>


  </q-layout>
</template>


<script>

import Home from '../components/Home.vue'
import PetSearch from 'src/components/PetSearch.vue'

export default {
  name: 'MainLayout',
  components: {
    Home,
    PetSearch,

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
    window.addEventListener('scroll', this.handleScroll)
  },
  beforeUnmount() {
    window.removeEventListener('scroll', this.handleScroll)
  }
}
</script>
