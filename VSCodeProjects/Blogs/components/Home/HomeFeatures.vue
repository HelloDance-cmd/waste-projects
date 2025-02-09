<script setup>
import {reactive} from "vue";

const featureList = reactive([
  { title: '100+', lable: 'Instructors' },
  { title: '500+', lable: 'Courses' },
  { title: 'Free', lable: 'Certifications' },
  { title: '2,000+', lable: 'Happy Members'}
]);

</script>

<template>
    <section id="features">
      <div class="feature-box container">
        <div class="row ">
          <div v-for="feature, idx in featureList" class="col-md-3 col-sm-6 mb-5 mb-md-0" :key="idx">
            <div class="feature-item py-5 rounded-4">
              <div class="feature-detail text-center">
                <h2 class="feature-title"> {{ feature.title }}</h2>
                <h6 class="feature-info text-uppercase">{{ feature.lable }}</h6>
              </div>
            </div>
          </div>
        </div>
      </div>
  </section>
</template>