<template>
  <v-container fluid>
    <v-row>
      <v-card
          v-for="(card, index) in cards"
          :key="index"
          class="mx-auto"
          style="height:300px; width:300px; margin-bottom:20px;"
          outlined
      >
        <v-list-item>
          <v-icon style="margin-top: 30%; margin-left: 37.5%;" color="primary" size="64">mdi-apps</v-icon>
        </v-list-item>
        <v-card-actions>
          <v-btn
              class="mx-auto"
              outlined
              rounded
              :to="card.link"
              style="font-weight:500; font-size:20px; border:solid 2px; max-width:250px; overflow:hidden; margin-top: 10%;"
          >
              {{ card.text }}
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: [
      {
          text: "작가 등록",
          link: "/writers",
      },
      {
          text: "EnrollView",
          link: "/enrollViews",
      },
      {
          text: "원고 관리",
          link: "/publishScripts",
      },
      {
          text: "WriteView",
          link: "/writeViews",
      },
      {
          text: "AI서비스",
          link: "/services",
      },
      {
          text: "사용자",
          link: "/users",
      },
      {
          text: "UserView",
          link: "/userViews",
      },
      {
          text: "책",
          link: "/books",
      },
      {
          text: "BookView",
          link: "/bookViews",
      },
      {
          text: "포인트",
          link: "/points",
      },
      {
          text: "PointView",
          link: "/pointViews",
      },
      {
          text: "결제",
          link: "/payments",
      },
      {
          text: "PaymentView",
          link: "/paymentViews",
      },
      {
          text: "책 관리",
          link: "/publishBooks",
      },
      {
          text: "PublishbookView",
          link: "/publishbookViews",
      },
      {
          text: "알림",
          link: "/알림",
      },
      {
          text: "AlertView",
          link: "/alertViews",
      },
    ],
  }),
};
</script>
