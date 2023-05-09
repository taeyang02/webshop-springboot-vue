<template>
  <div class="mt-5 d-flex justify-content-center">
    <button class="btn btn-primary" @click="previousPage">Back</button>
    <span class="mt-1 mx-2">{{ currentPage }} / {{ totalPages }}</span>
    <button class="btn btn-primary" @click="nextPage">Next</button>
  </div>
</template>

<script>
export default {
  name: "Pagination",
  props: {
    currentPage: {
      type: Number,
      required: true,
    },
    totalPages: {
      type: Number,
      required: true,
    },
    previousPage: {
      type: Function,
      required: true,
    },
    nextPage: {
      type: Function,
      required: true,
    },
  },
}
</script>

