(function() {
  Polymer({
    is: "accordion-with-toggle",

    properties: {
      /**
       * The text to place in the header of the accordion
       */
      headerValue: {
        type: String
      },

      /**
       * Icons to be used by the accordion component.
       * You should specify a valid iron icon for 'more' and 'less', at least,
       * plus an additional icon for 'action' if `showAction` is true.
       */
      icons: {
        type: Object,
        value: function () {
          return {
            more: "px-utl:chevron-right",
            less: "px-utl:chevron",
            action: "px-utl:edit"
          };
        }
      },

      /**
       * Flag indicating whether the accordion should be disabled.
       */
      disabled: {
        type: Boolean,
        value: false,
        reflectToAttribute: true
      },

      /**
       * Flag indicating whether the 'action' icon should be shown on the right hand side.
       */
      showAction: {
        type: Boolean,
        value: true,
        reflectToAttribute: true
      },

      /**
       * String that will appear in the right hand side of the accordion.
       */
      status: {
        type: String,
        value: ""
      },

      /**
       * If `true` the accordion is opened. If `false` it is closed. Use to
       * observe the user opening/closing the accordion, or set to programmatically
       * change the accordion state.
       */
      opened: {
        type: Boolean,
        value: false,
        notify: true,
        observer: "_handleOpenedChanged"
      },

      onSwitch: {
        type: Function,
        value: (e) => console.log(e)
      },

      /**
       * The icon to use in the accordion, either 'more' or 'less' depending on current state.
       */
      _expandCollapseIcon: {
        type: String,
        computed: "_getExpandCollapseIcon(opened, icons.more, icons.less)"
      }
    },

    _onSwitchPrivate: (e) => e.preventDefault() && console.log('_onSwitchPrivate Fired!'),

    _getExpandCollapseIcon: function(opened, iconMore, iconLess) {
      if (
        typeof opened === "boolean" &&
        typeof iconMore === "string" &&
        typeof iconLess === "string"
      ) {
        return opened ? iconLess : iconMore;
      }
    },

    /**
     * Shows or hides the accordion content.
     */
    toggle: function() {
      if (this.disabled) return;
      return this.opened = !this.opened;
    },

    /**
     * Internal toggle handler called when the user interacts with the
     * toggle icon. Toggles the accordion and sends an event that includes
     * the source DOM event that triggered the toggle.
     *
     * @param  {Event} e - Source tap/click event that triggered this handler
     */
    _toggleHandler: function(e) {
      const opened = this.toggle()

      opened ? this.fire("accordion-expanded", e) : this.fire("accordion-collapsed", e);

    },
    /**
     * Fired when the accordion is expanded by user interaction. This event is
     * not fired when the accordion is expanded through data-binding by
     * setting the `opened` property to true.
     *
     * e.target will be a reference to the accordion that was interacted with,
     * and e.detail will be a reference to the original DOM tap/click event.
     *
     * @event accordion-expanded
     */
    /**
     * Fired when the accordion is collapsed by user interaction. This event is
     * not fired when the accordion is collapsed through data-binding by
     * setting the `opened` property to false.
     *
     * e.target will be a reference to the accordion that was interacted with,
     * and e.detail will be a reference to the original DOM tap/click event.
     *
     * @event accordion-collapsed
     */

    _handleOpenedChanged: function(openedState) {
      if (typeof openedState === "boolean") {
        this.fire("accordion-opened-state-changed", { value: openedState });
      }
    }
  });
})();
