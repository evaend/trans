/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// identity function for calling harmony imports with the correct context
/******/ 	__webpack_require__.i = function(value) { return value; };
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/dist";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 58);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports) {

module.exports = window.jQuery;

/***/ }),
/* 1 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = { "default": __webpack_require__(20), __esModule: true };

/***/ }),
/* 2 */
/***/ (function(module, exports, __webpack_require__) {

// Thank's IE8 for his funny defineProperty
module.exports = !__webpack_require__(4)(function(){
  return Object.defineProperty({}, 'a', {get: function(){ return 7; }}).a != 7;
});

/***/ }),
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


exports.__esModule = true;

exports.default = function (instance, Constructor) {
  if (!(instance instanceof Constructor)) {
    throw new TypeError("Cannot call a class as a function");
  }
};

/***/ }),
/* 4 */
/***/ (function(module, exports) {

module.exports = function(exec){
  try {
    return !!exec();
  } catch(e){
    return true;
  }
};

/***/ }),
/* 5 */
/***/ (function(module, exports) {

// https://github.com/zloirock/core-js/issues/86#issuecomment-115759028
var global = module.exports = typeof window != 'undefined' && window.Math == Math
  ? window : typeof self != 'undefined' && self.Math == Math ? self : Function('return this')();
if(typeof __g == 'number')__g = global; // eslint-disable-line no-undef

/***/ }),
/* 6 */
/***/ (function(module, exports) {

module.exports = function(it){
  return typeof it === 'object' ? it !== null : typeof it === 'function';
};

/***/ }),
/* 7 */
/***/ (function(module, exports) {

var core = module.exports = {version: '2.4.0'};
if(typeof __e == 'number')__e = core; // eslint-disable-line no-undef

/***/ }),
/* 8 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return ajaxPost; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return getFormData; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return setFormData; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return resetFormData; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends__ = __webpack_require__(18);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_core_js_object_assign__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_core_js_object_assign___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_core_js_object_assign__);


/**
 * @file ajaxPost
 * @param {*} opts 
 * @param {*} cb 
 */
var ajaxPost = function ajaxPost() {
  var opts = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};
  var cb = arguments[1];

  $.ajax(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_core_js_object_assign___default()({}, {
    method: 'post',
    dataType: 'json'
  }, opts)).then(function (data) {
    if (data.status) {
      cb(data.result);
    } else {
      $.messager.alert('错误提示', data.msg || '发生未知异常,请联系管理员!');
    }
  });
};

/**
 * @file getFormData
 * @param {*} form 
 */
var getFormData = function getFormData(form, other) {
  var dataArray = form.serializeArray();
  var formData = {};
  dataArray.map(function (item, index) {
    return formData[item.name] = item.value;
  });
  return __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends___default()({}, formData, other);
};
/**
 * @desc 给予表单赋值
 * @param {*} form 
 * @param {*} data 
 */
var setFormData = function setFormData(form, data, callback) {
  for (var key in data) {
    var formField = form.find("[name='" + key + "']");
    var value = data[key];
    if ($.type(formField[0]) !== "undefined") {
      var fieldTagName = formField[0].tagName.toLowerCase();
      if (fieldTagName == "input") {
        if (formField.attr("type") == "radio") {
          $("input:radio[name='" + key + "'][value='" + value + "']").attr("checked", "checked");
        } else {
          formField.val(value);
        }
      } else if (fieldTagName == "select") {
        //do something special  
        formField.val(value);
      } else if (fieldTagName == "textarea") {
        //do something special  
        formField.val(value);
      } else {
        formField.val(value);
      }
    }
  }
  form.find('[data-readonly=true]').map(function (index, item) {
    $(item).prop('readonly', true).addClass('easyui-disabled');
  });
  if (typeof callback === 'function') callback();
};
/**
 * 表单重置
 * @param {*} form 
 */
var resetFormData = function resetFormData(form, callback) {
  form[0].reset();
  form.find('[type=hidden]').map(function (index, item) {
    return $(item).val('');
  });
  form.find('[data-readonly=true]').map(function (index, item) {
    $(item).prop('readonly', false).removeClass('easyui-disabled');
  });
  if (typeof callback === 'function') callback();
};
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__(0)))

/***/ }),
/* 9 */
/***/ (function(module, exports) {

// 7.2.1 RequireObjectCoercible(argument)
module.exports = function(it){
  if(it == undefined)throw TypeError("Can't call method on  " + it);
  return it;
};

/***/ }),
/* 10 */
/***/ (function(module, exports, __webpack_require__) {

// fallback for non-array-like ES3 and non-enumerable old V8 strings
var cof = __webpack_require__(24);
module.exports = Object('z').propertyIsEnumerable(0) ? Object : function(it){
  return cof(it) == 'String' ? it.split('') : Object(it);
};

/***/ }),
/* 11 */
/***/ (function(module, exports) {

// 7.1.4 ToInteger
var ceil  = Math.ceil
  , floor = Math.floor;
module.exports = function(it){
  return isNaN(it = +it) ? 0 : (it > 0 ? floor : ceil)(it);
};

/***/ }),
/* 12 */
/***/ (function(module, exports, __webpack_require__) {

// to indexed object, toObject with fallback for non-array-like ES3 strings
var IObject = __webpack_require__(10)
  , defined = __webpack_require__(9);
module.exports = function(it){
  return IObject(defined(it));
};

/***/ }),
/* 13 */
/***/ (function(module, exports, __webpack_require__) {

var global    = __webpack_require__(5)
  , core      = __webpack_require__(7)
  , ctx       = __webpack_require__(25)
  , hide      = __webpack_require__(29)
  , PROTOTYPE = 'prototype';

var $export = function(type, name, source){
  var IS_FORCED = type & $export.F
    , IS_GLOBAL = type & $export.G
    , IS_STATIC = type & $export.S
    , IS_PROTO  = type & $export.P
    , IS_BIND   = type & $export.B
    , IS_WRAP   = type & $export.W
    , exports   = IS_GLOBAL ? core : core[name] || (core[name] = {})
    , expProto  = exports[PROTOTYPE]
    , target    = IS_GLOBAL ? global : IS_STATIC ? global[name] : (global[name] || {})[PROTOTYPE]
    , key, own, out;
  if(IS_GLOBAL)source = name;
  for(key in source){
    // contains in native
    own = !IS_FORCED && target && target[key] !== undefined;
    if(own && key in exports)continue;
    // export native or passed
    out = own ? target[key] : source[key];
    // prevent global pollution for namespaces
    exports[key] = IS_GLOBAL && typeof target[key] != 'function' ? source[key]
    // bind timers to global for call from export context
    : IS_BIND && own ? ctx(out, global)
    // wrap global constructors for prevent change them in library
    : IS_WRAP && target[key] == out ? (function(C){
      var F = function(a, b, c){
        if(this instanceof C){
          switch(arguments.length){
            case 0: return new C;
            case 1: return new C(a);
            case 2: return new C(a, b);
          } return new C(a, b, c);
        } return C.apply(this, arguments);
      };
      F[PROTOTYPE] = C[PROTOTYPE];
      return F;
    // make static versions for prototype methods
    })(out) : IS_PROTO && typeof out == 'function' ? ctx(Function.call, out) : out;
    // export proto methods to core.%CONSTRUCTOR%.methods.%NAME%
    if(IS_PROTO){
      (exports.virtual || (exports.virtual = {}))[key] = out;
      // export proto methods to core.%CONSTRUCTOR%.prototype.%NAME%
      if(type & $export.R && expProto && !expProto[key])hide(expProto, key, out);
    }
  }
};
// type bitmap
$export.F = 1;   // forced
$export.G = 2;   // global
$export.S = 4;   // static
$export.P = 8;   // proto
$export.B = 16;  // bind
$export.W = 32;  // wrap
$export.U = 64;  // safe
$export.R = 128; // real proto method for `library` 
module.exports = $export;

/***/ }),
/* 14 */
/***/ (function(module, exports, __webpack_require__) {

var anObject       = __webpack_require__(22)
  , IE8_DOM_DEFINE = __webpack_require__(30)
  , toPrimitive    = __webpack_require__(42)
  , dP             = Object.defineProperty;

exports.f = __webpack_require__(2) ? Object.defineProperty : function defineProperty(O, P, Attributes){
  anObject(O);
  P = toPrimitive(P, true);
  anObject(Attributes);
  if(IE8_DOM_DEFINE)try {
    return dP(O, P, Attributes);
  } catch(e){ /* empty */ }
  if('get' in Attributes || 'set' in Attributes)throw TypeError('Accessors not supported!');
  if('value' in Attributes)O[P] = Attributes.value;
  return O;
};

/***/ }),
/* 15 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return message; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck__);


/**
 * @file message
 * @desc 提示
 */

var Message = function Message() {
  __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck___default()(this, Message);

  this.alert = function (opts) {
    $.messager.show({
      title: opts.title || '消息提醒',
      msg: opts.msg || '',
      timeout: opts.timeout || 2000,
      showType: 'slide'
    });
  };
};

var message = new Message();
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__(0)))

/***/ }),
/* 16 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return table; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__utils_common__ = __webpack_require__(8);


/**
 * table component
 */


var Table = function Table() {
  var _this = this;

  __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck___default()(this, Table);

  this.init = function (selector, opts) {
    if (selector && opts) {
      selector.datagrid(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign___default()({}, {
        method: 'get',
        height: $(window).height() + 20,
        collapsible: true,
        striped: true,
        rownumbers: true
      }, opts));
    } else {
      console.error('传入参数不正确!');
    }
  };

  this.reload = function (selector) {
    selector.datagrid('reload');
  };

  this.load = function (selector, params) {
    selector.datagrid('load', params);
  };

  this.append = function () {};

  this.delete = function (selector, url) {
    selector.datagrid('getSelections').map(function (item, index) {
      return selector.datagrid('deleteRow', selector.datagrid('getRowIndex', item));
    });
    if (url) {
      __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_2__utils_common__["d" /* ajaxPost */])({
        url: url,
        method: 'get'
      }, function (data) {
        if (data) {
          _this.reload(selector);
        }
      });
    }
  };

  this.clear = function () {};
}

//表格初始化
;

var table = new Table();
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__(0)))

/***/ }),
/* 17 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return modalWindow; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_createClass__ = __webpack_require__(46);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_createClass___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_createClass__);




/**
 * @file 窗口component
 */
var Window = function () {
  function Window() {
    __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck___default()(this, Window);

    this.close = function (selector) {
      selector.dialog('close');
    };

    this.open = function (selector) {
      selector.dialog('open');
    };

    this.title = '新建窗口';
  }

  __WEBPACK_IMPORTED_MODULE_2_babel_runtime_helpers_createClass___default()(Window, [{
    key: 'init',
    value: function init(selector, opts, ok, cancel) {
      var _this = this;

      selector.dialog(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign___default()({}, {
        width: $(window).width() * 0.8,
        height: $(window).width() * 0.35,
        title: this.title,
        draggable: false,
        closed: true,
        resizable: false,
        modal: true,
        buttons: [{
          text: '保存',
          handler: function handler() {
            if (typeof ok === 'function') ok(_this.title);
          },
          iconCls: 'icon-save'
        }, {
          text: '关闭',
          handler: function handler() {
            if (typeof cancel === 'function') cancel();
            _this.close(selector);
          },
          iconCls: 'icon-cancel'
        }]
      }, opts));
      this.title = opts.title || this.title;
    }
  }, {
    key: 'setTitle',
    value: function setTitle(selector, text) {
      selector.dialog('setTitle', '' + text || '重命名');
      this.title = text;
      return this;
    }
  }]);

  return Window;
}();

var modalWindow = new Window();
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__(0)))

/***/ }),
/* 18 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


exports.__esModule = true;

var _assign = __webpack_require__(1);

var _assign2 = _interopRequireDefault(_assign);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = _assign2.default || function (target) {
  for (var i = 1; i < arguments.length; i++) {
    var source = arguments[i];

    for (var key in source) {
      if (Object.prototype.hasOwnProperty.call(source, key)) {
        target[key] = source[key];
      }
    }
  }

  return target;
};

/***/ }),
/* 19 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return gridDelete; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return gridEdit; });
/**
 * @file grid delete
 * @param {*} grid 
 */
var gridDelete = function gridDelete(grid, callback) {
  var selectd = grid.datagrid('getSelections');
  var len = selectd.length;
  if (len === 0) {
    $.messager.alert('提示', '至少选择一项', 'info');
  } else {
    $.messager.confirm('删除确认框', '您确认删除这(批)数据吗？', function (r) {
      if (r) {
        callback(selectd);
      }
    });
  }
};

/**
 * @file grid edit
 * @param {*} grid 
 */
var gridEdit = function gridEdit(grid, callback) {
  var selectd = grid.datagrid('getSelections');
  var len = selectd.length;
  if (len === 0) {
    $.messager.alert('提示', '至少选择一项', 'info');
  } else if (len > 1) {
    $.messager.alert('提示', '只允许选择一项', 'info');
  } else {
    callback(selectd);
  }
};
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__(0)))

/***/ }),
/* 20 */
/***/ (function(module, exports, __webpack_require__) {

__webpack_require__(44);
module.exports = __webpack_require__(7).Object.assign;

/***/ }),
/* 21 */
/***/ (function(module, exports) {

module.exports = function(it){
  if(typeof it != 'function')throw TypeError(it + ' is not a function!');
  return it;
};

/***/ }),
/* 22 */
/***/ (function(module, exports, __webpack_require__) {

var isObject = __webpack_require__(6);
module.exports = function(it){
  if(!isObject(it))throw TypeError(it + ' is not an object!');
  return it;
};

/***/ }),
/* 23 */
/***/ (function(module, exports, __webpack_require__) {

// false -> Array#indexOf
// true  -> Array#includes
var toIObject = __webpack_require__(12)
  , toLength  = __webpack_require__(40)
  , toIndex   = __webpack_require__(39);
module.exports = function(IS_INCLUDES){
  return function($this, el, fromIndex){
    var O      = toIObject($this)
      , length = toLength(O.length)
      , index  = toIndex(fromIndex, length)
      , value;
    // Array#includes uses SameValueZero equality algorithm
    if(IS_INCLUDES && el != el)while(length > index){
      value = O[index++];
      if(value != value)return true;
    // Array#toIndex ignores holes, Array#includes - not
    } else for(;length > index; index++)if(IS_INCLUDES || index in O){
      if(O[index] === el)return IS_INCLUDES || index || 0;
    } return !IS_INCLUDES && -1;
  };
};

/***/ }),
/* 24 */
/***/ (function(module, exports) {

var toString = {}.toString;

module.exports = function(it){
  return toString.call(it).slice(8, -1);
};

/***/ }),
/* 25 */
/***/ (function(module, exports, __webpack_require__) {

// optional / simple context binding
var aFunction = __webpack_require__(21);
module.exports = function(fn, that, length){
  aFunction(fn);
  if(that === undefined)return fn;
  switch(length){
    case 1: return function(a){
      return fn.call(that, a);
    };
    case 2: return function(a, b){
      return fn.call(that, a, b);
    };
    case 3: return function(a, b, c){
      return fn.call(that, a, b, c);
    };
  }
  return function(/* ...args */){
    return fn.apply(that, arguments);
  };
};

/***/ }),
/* 26 */
/***/ (function(module, exports, __webpack_require__) {

var isObject = __webpack_require__(6)
  , document = __webpack_require__(5).document
  // in old IE typeof document.createElement is 'object'
  , is = isObject(document) && isObject(document.createElement);
module.exports = function(it){
  return is ? document.createElement(it) : {};
};

/***/ }),
/* 27 */
/***/ (function(module, exports) {

// IE 8- don't enum bug keys
module.exports = (
  'constructor,hasOwnProperty,isPrototypeOf,propertyIsEnumerable,toLocaleString,toString,valueOf'
).split(',');

/***/ }),
/* 28 */
/***/ (function(module, exports) {

var hasOwnProperty = {}.hasOwnProperty;
module.exports = function(it, key){
  return hasOwnProperty.call(it, key);
};

/***/ }),
/* 29 */
/***/ (function(module, exports, __webpack_require__) {

var dP         = __webpack_require__(14)
  , createDesc = __webpack_require__(36);
module.exports = __webpack_require__(2) ? function(object, key, value){
  return dP.f(object, key, createDesc(1, value));
} : function(object, key, value){
  object[key] = value;
  return object;
};

/***/ }),
/* 30 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = !__webpack_require__(2) && !__webpack_require__(4)(function(){
  return Object.defineProperty(__webpack_require__(26)('div'), 'a', {get: function(){ return 7; }}).a != 7;
});

/***/ }),
/* 31 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";

// 19.1.2.1 Object.assign(target, source, ...)
var getKeys  = __webpack_require__(34)
  , gOPS     = __webpack_require__(32)
  , pIE      = __webpack_require__(35)
  , toObject = __webpack_require__(41)
  , IObject  = __webpack_require__(10)
  , $assign  = Object.assign;

// should work with symbols and should have deterministic property order (V8 bug)
module.exports = !$assign || __webpack_require__(4)(function(){
  var A = {}
    , B = {}
    , S = Symbol()
    , K = 'abcdefghijklmnopqrst';
  A[S] = 7;
  K.split('').forEach(function(k){ B[k] = k; });
  return $assign({}, A)[S] != 7 || Object.keys($assign({}, B)).join('') != K;
}) ? function assign(target, source){ // eslint-disable-line no-unused-vars
  var T     = toObject(target)
    , aLen  = arguments.length
    , index = 1
    , getSymbols = gOPS.f
    , isEnum     = pIE.f;
  while(aLen > index){
    var S      = IObject(arguments[index++])
      , keys   = getSymbols ? getKeys(S).concat(getSymbols(S)) : getKeys(S)
      , length = keys.length
      , j      = 0
      , key;
    while(length > j)if(isEnum.call(S, key = keys[j++]))T[key] = S[key];
  } return T;
} : $assign;

/***/ }),
/* 32 */
/***/ (function(module, exports) {

exports.f = Object.getOwnPropertySymbols;

/***/ }),
/* 33 */
/***/ (function(module, exports, __webpack_require__) {

var has          = __webpack_require__(28)
  , toIObject    = __webpack_require__(12)
  , arrayIndexOf = __webpack_require__(23)(false)
  , IE_PROTO     = __webpack_require__(37)('IE_PROTO');

module.exports = function(object, names){
  var O      = toIObject(object)
    , i      = 0
    , result = []
    , key;
  for(key in O)if(key != IE_PROTO)has(O, key) && result.push(key);
  // Don't enum bug & hidden keys
  while(names.length > i)if(has(O, key = names[i++])){
    ~arrayIndexOf(result, key) || result.push(key);
  }
  return result;
};

/***/ }),
/* 34 */
/***/ (function(module, exports, __webpack_require__) {

// 19.1.2.14 / 15.2.3.14 Object.keys(O)
var $keys       = __webpack_require__(33)
  , enumBugKeys = __webpack_require__(27);

module.exports = Object.keys || function keys(O){
  return $keys(O, enumBugKeys);
};

/***/ }),
/* 35 */
/***/ (function(module, exports) {

exports.f = {}.propertyIsEnumerable;

/***/ }),
/* 36 */
/***/ (function(module, exports) {

module.exports = function(bitmap, value){
  return {
    enumerable  : !(bitmap & 1),
    configurable: !(bitmap & 2),
    writable    : !(bitmap & 4),
    value       : value
  };
};

/***/ }),
/* 37 */
/***/ (function(module, exports, __webpack_require__) {

var shared = __webpack_require__(38)('keys')
  , uid    = __webpack_require__(43);
module.exports = function(key){
  return shared[key] || (shared[key] = uid(key));
};

/***/ }),
/* 38 */
/***/ (function(module, exports, __webpack_require__) {

var global = __webpack_require__(5)
  , SHARED = '__core-js_shared__'
  , store  = global[SHARED] || (global[SHARED] = {});
module.exports = function(key){
  return store[key] || (store[key] = {});
};

/***/ }),
/* 39 */
/***/ (function(module, exports, __webpack_require__) {

var toInteger = __webpack_require__(11)
  , max       = Math.max
  , min       = Math.min;
module.exports = function(index, length){
  index = toInteger(index);
  return index < 0 ? max(index + length, 0) : min(index, length);
};

/***/ }),
/* 40 */
/***/ (function(module, exports, __webpack_require__) {

// 7.1.15 ToLength
var toInteger = __webpack_require__(11)
  , min       = Math.min;
module.exports = function(it){
  return it > 0 ? min(toInteger(it), 0x1fffffffffffff) : 0; // pow(2, 53) - 1 == 9007199254740991
};

/***/ }),
/* 41 */
/***/ (function(module, exports, __webpack_require__) {

// 7.1.13 ToObject(argument)
var defined = __webpack_require__(9);
module.exports = function(it){
  return Object(defined(it));
};

/***/ }),
/* 42 */
/***/ (function(module, exports, __webpack_require__) {

// 7.1.1 ToPrimitive(input [, PreferredType])
var isObject = __webpack_require__(6);
// instead of the ES6 spec version, we didn't implement @@toPrimitive case
// and the second argument - flag - preferred type is a string
module.exports = function(it, S){
  if(!isObject(it))return it;
  var fn, val;
  if(S && typeof (fn = it.toString) == 'function' && !isObject(val = fn.call(it)))return val;
  if(typeof (fn = it.valueOf) == 'function' && !isObject(val = fn.call(it)))return val;
  if(!S && typeof (fn = it.toString) == 'function' && !isObject(val = fn.call(it)))return val;
  throw TypeError("Can't convert object to primitive value");
};

/***/ }),
/* 43 */
/***/ (function(module, exports) {

var id = 0
  , px = Math.random();
module.exports = function(key){
  return 'Symbol('.concat(key === undefined ? '' : key, ')_', (++id + px).toString(36));
};

/***/ }),
/* 44 */
/***/ (function(module, exports, __webpack_require__) {

// 19.1.3.1 Object.assign(target, source)
var $export = __webpack_require__(13);

$export($export.S + $export.F, 'Object', {assign: __webpack_require__(31)});

/***/ }),
/* 45 */
/***/ (function(module, exports, __webpack_require__) {

module.exports = { "default": __webpack_require__(47), __esModule: true };

/***/ }),
/* 46 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


exports.__esModule = true;

var _defineProperty = __webpack_require__(45);

var _defineProperty2 = _interopRequireDefault(_defineProperty);

function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { default: obj }; }

exports.default = function () {
  function defineProperties(target, props) {
    for (var i = 0; i < props.length; i++) {
      var descriptor = props[i];
      descriptor.enumerable = descriptor.enumerable || false;
      descriptor.configurable = true;
      if ("value" in descriptor) descriptor.writable = true;
      (0, _defineProperty2.default)(target, descriptor.key, descriptor);
    }
  }

  return function (Constructor, protoProps, staticProps) {
    if (protoProps) defineProperties(Constructor.prototype, protoProps);
    if (staticProps) defineProperties(Constructor, staticProps);
    return Constructor;
  };
}();

/***/ }),
/* 47 */
/***/ (function(module, exports, __webpack_require__) {

__webpack_require__(48);
var $Object = __webpack_require__(7).Object;
module.exports = function defineProperty(it, key, desc){
  return $Object.defineProperty(it, key, desc);
};

/***/ }),
/* 48 */
/***/ (function(module, exports, __webpack_require__) {

var $export = __webpack_require__(13);
// 19.1.2.4 / 15.2.3.6 Object.defineProperty(O, P, Attributes)
$export($export.S + $export.F * !__webpack_require__(2), 'Object', {defineProperty: __webpack_require__(14).f});

/***/ }),
/* 49 */
/***/ (function(module, exports, __webpack_require__) {

/* WEBPACK VAR INJECTION */(function($) {/**
 * @file ValidateRules 校验规则
 */
$.extend($.fn.validatebox.defaults.rules, {
  minLength: {
    validator: function validator(value, param) {
      return value.length >= param[0];
    },
    message: '至少输入 {0} 个字符.'
  },
  maxLength: {
    validator: function validator(value, param) {
      return value.length <= param[0];
    },
    message: '最多输入 {0} 个字符.'
  },
  number: {
    validator: function validator(value, param) {
      return (/^[0-9]\d*(\.\d+)?$/.test(value)
      ); //number: /^\d+$/,//数字value.length >= param[0];   
    },
    message: '请输入数字'
  }
});

$.fn.combobox.defaults.onHidePanel = function () {
  var valueField = $(this).combobox("options").valueField;
  var val = $(this).combobox("getValue"); //当前combobox的值
  var allData = $(this).combobox("getData"); //获取combobox所有数据
  var result = true; //为true说明输入的值在下拉框数据中不存在
  for (var i = 0; i < allData.length; i++) {
    if (val == allData[i][valueField]) {
      result = false;
    }
  }
  if (result) {
    $(this).combobox("clear");
  }
};
/* WEBPACK VAR INJECTION */}.call(exports, __webpack_require__(0)))

/***/ }),
/* 50 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return cascade; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign__ = __webpack_require__(1);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck__);



/**
 * @file 级联菜单
 */

var Cascade = function Cascade() {
  var _this = this;

  __WEBPACK_IMPORTED_MODULE_1_babel_runtime_helpers_classCallCheck___default()(this, Cascade);

  this.init = function (params) {
    var selectors = params.selectors,
        url = params.url,
        children = params.children;

    try {
      var _loop = function _loop(i) {
        var opts = { method: 'get' };
        if (i === 0) {
          opts.url = url;
        }
        if (children[i] && selectors[i + 1]) {
          opts.onSelect = function (record) {
            selectors[i + 1].combobox('setValue', '');
            selectors[i + 1].combobox('reload', children[i] + '&pid=' + record.id);
          };
        }
        _this.combobox(selectors[i], opts);
      };

      for (var i = 0; i < selectors.length; i++) {
        _loop(i);
      }
    } catch (error) {
      console.error(error);
    }
  };

  this.combobox = function (selector, opts) {
    selector.combobox(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_core_js_object_assign___default()({}, {
      mode: 'remote',
      url: opts.url || '',
      valueField: 'id',
      textField: 'text',
      width: 200,
      height: 28
    }, opts || {}));
  };
};

var cascade = new Cascade();

/***/ }),
/* 51 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function($) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return location; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck__ = __webpack_require__(3);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck__);


/**
 * @file 地址初始化
 */
var Location = function Location() {
  var _this = this;

  __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_classCallCheck___default()(this, Location);

  this.init = function (selectors) {
    var url = arguments.length > 1 && arguments[1] !== undefined ? arguments[1] : '';

    if ($.isArray(selectors)) {
      selectors.map(function (item, index) {
        return _this.create(item, url);
      });
    } else {
      _this.create(selectors, url);
    }
  };

  this.create = function (selector, url) {
    selector.combobox({
      mode: 'remote',
      url: url || '../staticData/searchLocationsForSelect',
      valueField: 'text',
      textField: 'text',
      width: 200,
      height: 28
    });
  };
};

var location = new Location();
/* WEBPACK VAR INJECTION */}.call(__webpack_exports__, __webpack_require__(0)))

/***/ }),
/* 52 */,
/* 53 */,
/* 54 */,
/* 55 */,
/* 56 */,
/* 57 */,
/* 58 */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends__ = __webpack_require__(18);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__component_table__ = __webpack_require__(16);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__component_window__ = __webpack_require__(17);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__utils_common__ = __webpack_require__(8);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__component_message__ = __webpack_require__(15);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__actions_grid__ = __webpack_require__(19);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__component_location__ = __webpack_require__(51);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__component_cascade__ = __webpack_require__(50);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_jQuery__ = __webpack_require__(0);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8_jQuery___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_8_jQuery__);









__webpack_require__(49);
var $grid = __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#incomeGrid'),
    $dialog = __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#incomeDialog'),
    $form = __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#incomeFf');
//地址初始化      
__WEBPACK_IMPORTED_MODULE_6__component_location__["a" /* location */].init([__WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationFromSearch'), __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationToSearch'), __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationFrom'), __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationTo')]);
//车型品牌初始化
__WEBPACK_IMPORTED_MODULE_7__component_cascade__["a" /* cascade */].init({
  selectors: [__WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#carBrand'), __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#carModel')],
  url: '../staticData/carFindForSelect?type=brand',
  children: ['../staticData/carFindForSelect?type=model&']
});

//consignOrgName
__WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#consignOrgId').combobox({
  url: '../staticData/searchOrgForSelect',
  valueField: 'id',
  textField: 'text',
  editable: false,
  width: 200,
  height: 28
});
//表格初始化
__WEBPACK_IMPORTED_MODULE_1__component_table__["a" /* table */].init($grid, {
  toolbar: [{
    text: '新增',
    iconCls: 'icon-add',
    handler: function handler() {
      __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__utils_common__["b" /* resetFormData */])($form, function () {
        __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationFrom').combobox('setValue', '');
        __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationTo').combobox('setValue', '');
        __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#carBrand').combobox('setValue', '');
        __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#carModel').combobox('setValue', '');
        __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#consignOrgId').combobox('setValue', '');
      });
      __WEBPACK_IMPORTED_MODULE_2__component_window__["a" /* modalWindow */].setTitle($dialog, '新增').open($dialog);
    }
  }, '-', {
    text: '编辑',
    iconCls: 'icon-edit',
    handler: function handler() {
      __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_5__actions_grid__["a" /* gridEdit */])($grid, function (rows) {
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__utils_common__["c" /* setFormData */])($form, rows[0], function () {
          __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#consignOrgId').combobox('setValue', rows[0].consignOrgId);
          __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationFrom').combobox('setValue', rows[0].locationFrom);
          __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#locationTo').combobox('setValue', rows[0].locationTo);
          __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#carBrand').combobox('setValue', rows[0].carBrand);
          __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#carModel').combobox('setValue', rows[0].carModel);
        });
        __WEBPACK_IMPORTED_MODULE_2__component_window__["a" /* modalWindow */].setTitle($dialog, '编辑').open($dialog);
      });
    }
  }, '-', {
    text: '删除',
    iconCls: 'icon-remove',
    handler: function handler() {
      __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_5__actions_grid__["b" /* gridDelete */])($grid, function (rows) {
        var contractIds = [];
        rows.map(function (item, index) {
          return contractIds.push(item.contractId);
        });
        // 后台交互
        __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__utils_common__["d" /* ajaxPost */])({ url: '../contractRecords/deleteContract', data: { contractIds: contractIds } }, function (data) {
          console.log('删除数据', contractIds);
          // 刷新表格
          __WEBPACK_IMPORTED_MODULE_1__component_table__["a" /* table */].reload($grid);
        });
      });
    }
  }],
  title: '收入合同表',
  url: '../contractRecords/searchContractInfo', //'../../lib/mock/incomeContract.json',
  height: __WEBPACK_IMPORTED_MODULE_8_jQuery___default()(window).height() - 95,
  columns: [[{ field: 'contractId', checkbox: true }, { field: 'consignOrgId', hidden: true }, { field: 'consignOrgName', title: '托运单位', width: 260 }, { field: 'locationFrom', title: '起运地', width: 260 }, { field: 'locationTo', title: '目的地', width: 100 }, { field: 'carBrand', title: '品牌', width: 100 }, { field: 'carModel', title: '车型', width: 100 }, { field: 'freightRates', title: '运价', width: 100, textAlign: 'right' }, { field: 'chargePeriod', title: '结费周期', width: 100 }, { field: 'contractStart', title: '合同开始日期', width: 120 }, { field: 'contractEnd', title: '合同结束日期', width: 120 }, { field: 'modifier', title: '修改人', width: 120 }, { field: 'modifyDate', title: '修改日期', width: 120 }]],
  queryParams: {
    contractType: '01'
  }
});

__WEBPACK_IMPORTED_MODULE_2__component_window__["a" /* modalWindow */].init($dialog, { title: '收入合同' }, function (text) {
  var postData = __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends___default()({}, __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__utils_common__["a" /* getFormData */])($form), {
    consignOrgName: __WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#consignOrgId').combobox('getText'),
    contractType: '01'
  });
  //===== 校验 =======
  //===== 校验结束 =====
  var isValid = $form.form('validate');
  if (isValid) {
    __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__utils_common__["d" /* ajaxPost */])({ url: '../contractRecords/addUpdateContractInfo', data: postData }, function (data) {
      //===== 校验结束 =====
      console.log('一条记录', postData);
      //新增成功,关闭窗口
      __WEBPACK_IMPORTED_MODULE_2__component_window__["a" /* modalWindow */].close($dialog);
      __WEBPACK_IMPORTED_MODULE_4__component_message__["a" /* message */].alert({
        msg: '\u6536\u5165\u5408\u540C' + text + '\u6210\u529F'
      });
      //表格刷新
      __WEBPACK_IMPORTED_MODULE_1__component_table__["a" /* table */].reload($grid);
    });
  }
});

//查询按钮
__WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#search').on('click', function () {
  var postData = __WEBPACK_IMPORTED_MODULE_0_babel_runtime_helpers_extends___default()({}, __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__utils_common__["a" /* getFormData */])(__WEBPACK_IMPORTED_MODULE_8_jQuery___default()('#ff')), {
    contractType: '01'
  });
  console.log(postData);
  //刷新表格
  __WEBPACK_IMPORTED_MODULE_1__component_table__["a" /* table */].load($grid, postData);
});

/***/ })
/******/ ]);