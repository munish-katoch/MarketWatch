(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports'], factory);
  else if (typeof exports === 'object')
    factory(module.exports);
  else
    root['MarketWatch:shared'] = factory(typeof this['MarketWatch:shared'] === 'undefined' ? {} : this['MarketWatch:shared']);
}(this, function (_) {
  'use strict';
  //region block: pre-declaration
  //endregion
  return _;
}));

//# sourceMappingURL=MarketWatch-shared.js.map
