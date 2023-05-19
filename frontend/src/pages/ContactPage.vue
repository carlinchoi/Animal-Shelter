<template>
  <div class="contact-container">
    <h2 class="contact-heading text-primary q-mb-md" style="margin-top: 10%;">Contact Us</h2>
    <q-card class="contact-card q-flex-center">
      <q-card-section>
        <q-list bordered class="q-flex-center">
          <q-item v-for="contactItem in contactItems" :key="contactItem.label">
            <q-item-section>
              <q-item-section>
                <q-item-label class="contact-label q-mb-xs">
                  <div class="contact-label-text">{{ contactItem.label }}</div>
                  <div class="contact-text">{{ contactItem.text }}</div>
                </q-item-label>
              </q-item-section>
            </q-item-section>
          </q-item>
        </q-list>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      contactItems: [
        {
          icon: "email",
          label: "Email",
          text: "contact@rockvilleanimalshelter.com",
        },
        {
          icon: "phone",
          label: "Phone",
          text: "123-456-7890",
        },
        {
          icon: "location_on",
          label: "Address",
          text: "123 Main St, Rockville, USA",
        },
      ],
    };
  },
};
</script>

<style>

</style>
