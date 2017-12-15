(function () {
  Polymer({

    is: 'px-report-detail',

    properties: {
      title: {
        type: String,
        value: "L7044GSI Report Forecast #2"
      },
      selected: {
        type: String,
        value: "0"
      },
      /**
       * Items to be displayed in the left nav list.
       * @property listItems
       */
      listItems: {
        type: Array,
        value: function () {
          return [{ "id": "1", "title": "Engine"}, { "id": "2", "title": "Parts" }, { "id": "3", "title": "Fuel"}, { "id": "4", "title": "Lubrication" }, { "id": "5", "title": "Labor" }];
        }
      }

    },

    _toggleEngine: function () {
      console.log('_toggleEngine fired!')
    }
  });
})();
//# sourceMappingURL=px-report-detail.js.map
