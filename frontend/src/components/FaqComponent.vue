<template>
  <div class="faq-wrapper">
    <q-container class="q-pa-lg">
      <h1 class="text-h2 text-primary q-mb-md">Frequently Asked Questions</h1>
      <q-card class="faq-card" v-for="faq in faqs" :key="faq.id">
        <q-card-section class="q-pa-md">
          <h3 class="text-h5 text-primary">{{ faq.question }}</h3>
          <p class="q-mt-sm">
            <!-- Conditional link for specific question -->
            <template v-if="faq.question === 'Can I volunteer at the shelter?'">
              {{ faq.answer }}
              <router-link :to="{ name: 'VolunteerRegister' }"
                >Click here</router-link
              >
              to apply as a volunteer!
            </template>
            <template v-else>
              {{ faq.answer }}
            </template>
          </p>
        </q-card-section>
      </q-card>
    </q-container>
  </div>
</template>

<script>
export default {
  name: "FaqComponent",
  data() {
    return {
      faqs: [
        {
          id: 1,
          question: "What are the adoption fees?",
          answer:
            "Our adoption fees vary depending on the type of animal. For detailed information, please visit our Adoption page.",
        },
        {
          id: 2,
          question: "Do you offer spaying/neutering services?",
          answer:
            "Yes, we provide spaying/neutering services for all adopted animals to help control the pet population.",
        },
        {
          id: 3,
          question: "Can I volunteer at the shelter?",
          answer:
            "Absolutely! We welcome volunteers who are passionate about animal welfare. Please fill out our form and register to become a volunteer. Once approved by one of our Admins, you will be able to volunteer and obtain volunteer privileges.",
        },
        {
          id: 4,
          question: "What should I do if I find a stray animal?",
          answer:
            "If you find a stray animal, please contact our shelter immediately. We will guide you through the necessary steps to ensure the animal's safety.",
        },
        {
          id: 5,
          question: "Do you accept donations?",
          answer:
            "Yes, we greatly appreciate donations to support our work in caring for the animals. Please visit our office to see how you can contribute.",
        },
      ],
    };
  },
};
</script>

<style>
.faq-card {
  margin-bottom: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.text-primary {
  color: #2196f3;
}

.text-h3 {
  font-size: 24px;
}

.text-h5 {
  font-size: 20px;
}

.q-pa-lg {
  padding: 40px;
}

.q-mb-md {
  margin-bottom: 16px;
}

.q-mt-sm {
  margin-top: 8px;
}
</style>
