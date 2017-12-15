(function () {
  Polymer({
    is: "px-lcc-app",

    properties: {
      /**
       * Used by the px-app-nav to automatically select the first item.
       * @property selected
       */
      selected: {
        type: Array,
        value: function () {
          return ["dashboard"];
        }
      },
      /**
       * Used as the title of the dashboard page.
       * @property selectedAsset
       */
      selectedAsset: {
        type: String,
        value: ""
      }
    },
    /**
     * Used by the dom-if to test equality.
     * @param {Array} route
     * @param {String} string
     */
    isEqual(route, string) {
      return route[0] === string;
    }
  });
})();
//# sourceMappingURL=px-lcc-app.js.map
