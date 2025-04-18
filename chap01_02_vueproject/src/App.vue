<template>
  <div class="plus">
    <h1>덧셈 기능 만들기</h1>
    <label>num: 1</label><input type="text" v-model="num1">&nbsp;
    <label>num: 2</label><input type="text" v-model="num2">&nbsp;
    <button @click="sendPlus">더하기</button>
    <hr>
    <p>{{ num1 }} + {{ num2 }} = {{ sum }}</p>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const num1 = ref(0);
const num2 = ref(0);
const sum = ref(0);

const sendPlus = async () => {

  /* 1. 백엔드에서 cors, 프론트 x */
  // const response = await fetch(`http://localhost:7777/plus?num1=${num1.value}&num2=${num2.value}`);

  /* 2. 백엔드에서 X, 프론트에서 cors */
  // 직접 브라우저가 백엔드로 가게 하지 않고, 뷰 자체 개발 환경에서 백엔드로 가게 한다.

  /* 이 후 코드는 post 요청에 request body 활용(백엔드도 수정) */
  // const response = await fetch(`http://localhost:5173/api/plus?num1=${num1.value}&num2=${num2.value}`);

  // const response = await fetch(`http://localhost:5173/api/plus`, {
  //   method: 'POST',
  //   headers: {
  //     'Content-Type': 'application/json;charset=utf-8;'
  //   },
  //   body: JSON.stringify({num1: num1.value, num2: num2.value})
  // });

  /* 3. 백엔드에서 cors, 프론트에서 x (백엔드 + 프론트엔드 둘 다 컨테이너화 이후) */
  const response = await fetch(`http://localhost:8055/plus`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8;'
    },
    body: JSON.stringify({num1: num1.value, num2: num2.value})
  });
  const data = await response.json();
  console.log('data:', data);
  sum.value = data.sum;
}


</script>

<style scoped>
.plus {
  text-align: center;
}
</style>