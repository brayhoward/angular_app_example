(function () {
  Polymer({

    is: 'px-sample-report',

    properties: {
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

    }
  });
})();
//# sourceMappingURL=px-sample-report.js.map
