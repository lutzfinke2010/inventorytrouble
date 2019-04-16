(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/GlobalSettings.ts":
/*!***********************************!*\
  !*** ./src/app/GlobalSettings.ts ***!
  \***********************************/
/*! exports provided: GlobalSettings */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GlobalSettings", function() { return GlobalSettings; });
var GlobalSettings = /** @class */ (function () {
    function GlobalSettings() {
    }
    GlobalSettings.MENUEEINTRAG = '';
    GlobalSettings.KostenProSektor = 1;
    return GlobalSettings;
}());



/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<app-menu></app-menu>\n<router-outlet></router-outlet>\n"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _websocket_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./websocket.service */ "./src/app/websocket.service.ts");
/* harmony import */ var _chatservice_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./chatservice.service */ "./src/app/chatservice.service.ts");




var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.list = [
            {
                name: 'Hallo',
                link: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
            },
            {
                name: 'Wer',
                link: 'https://material.angular.io/assets/img/examples/shiba1.jpg'
            },
            {
                name: 'bist',
                link: 'https://material.angular.io/assets/img/examples/shiba2.jpg'
            },
            {
                name: 'du!',
                link: 'https://material.angular.io/assets/img/examples/shiba1.jpg'
            }
        ];
    }
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            providers: [_websocket_service__WEBPACK_IMPORTED_MODULE_2__["WebsocketService"], _chatservice_service__WEBPACK_IMPORTED_MODULE_3__["ChatService"]],
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm5/material.es5.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm5/animations.js");
/* harmony import */ var _angular_flex_layout__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/flex-layout */ "./node_modules/@angular/flex-layout/esm5/flex-layout.es5.js");
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/material/card */ "./node_modules/@angular/material/esm5/card.es5.js");
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/grid-list */ "./node_modules/@angular/material/esm5/grid-list.es5.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/esm5/button.es5.js");
/* harmony import */ var _menu_menu_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./menu/menu.component */ "./src/app/menu/menu.component.ts");
/* harmony import */ var _game_card_game_card_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./game-card/game-card.component */ "./src/app/game-card/game-card.component.ts");
/* harmony import */ var ngx_paypal__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ngx-paypal */ "./node_modules/ngx-paypal/fesm5/ngx-paypal.js");
/* harmony import */ var _paypal_button_paypal_button_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./paypal-button/paypal-button.component */ "./src/app/paypal-button/paypal-button.component.ts");
/* harmony import */ var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/checkbox */ "./node_modules/@angular/material/esm5/checkbox.es5.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _server_options_server_options_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./server-options/server-options.component */ "./src/app/server-options/server-options.component.ts");
/* harmony import */ var _game_card_list_game_card_list_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./game-card-list/game-card-list.component */ "./src/app/game-card-list/game-card-list.component.ts");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./app.routing.module */ "./src/app/app.routing.module.ts");
/* harmony import */ var _service_rblgame_service__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./service/rblgame.service */ "./src/app/service/rblgame.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _constants__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./constants */ "./src/app/constants.ts");
/* harmony import */ var _websocket_service__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./websocket.service */ "./src/app/websocket.service.ts");
/* harmony import */ var _chatservice_service__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./chatservice.service */ "./src/app/chatservice.service.ts");
/* harmony import */ var _ticket_alert_ticket_alert_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./ticket-alert/ticket-alert.component */ "./src/app/ticket-alert/ticket-alert.component.ts");
/* harmony import */ var _angular_service_worker__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/service-worker */ "./node_modules/@angular/service-worker/fesm5/service-worker.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ../environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _service_rblgame_searchoptions__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./service/rblgame.searchoptions */ "./src/app/service/rblgame.searchoptions.ts");




























var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _menu_menu_component__WEBPACK_IMPORTED_MODULE_10__["MenuComponent"],
                _game_card_game_card_component__WEBPACK_IMPORTED_MODULE_11__["GameCardComponent"],
                _paypal_button_paypal_button_component__WEBPACK_IMPORTED_MODULE_13__["PaypalButtonComponent"],
                _server_options_server_options_component__WEBPACK_IMPORTED_MODULE_16__["ServerOptionsComponent"],
                _game_card_list_game_card_list_component__WEBPACK_IMPORTED_MODULE_17__["GameCardListComponent"],
                _ticket_alert_ticket_alert_component__WEBPACK_IMPORTED_MODULE_24__["TicketAlertComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _app_routing_module__WEBPACK_IMPORTED_MODULE_18__["AppRoutingModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatListModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_5__["BrowserAnimationsModule"],
                _angular_flex_layout__WEBPACK_IMPORTED_MODULE_6__["FlexLayoutModule"],
                _angular_material_card__WEBPACK_IMPORTED_MODULE_7__["MatCardModule"],
                _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_8__["MatGridListModule"],
                _angular_material_button__WEBPACK_IMPORTED_MODULE_9__["MatButtonModule"],
                ngx_paypal__WEBPACK_IMPORTED_MODULE_12__["NgxPayPalModule"],
                _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__["MatCheckboxModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_15__["FormsModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_15__["ReactiveFormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_20__["HttpClientModule"],
                _angular_service_worker__WEBPACK_IMPORTED_MODULE_25__["ServiceWorkerModule"].register('ngsw-worker.js', { enabled: _environments_environment__WEBPACK_IMPORTED_MODULE_26__["environment"].production }),
            ],
            exports: [
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatSidenavModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatToolbarModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatIconModule"],
                _angular_material__WEBPACK_IMPORTED_MODULE_4__["MatListModule"],
                _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_5__["BrowserAnimationsModule"]
            ],
            providers: [
                { provide: _constants__WEBPACK_IMPORTED_MODULE_21__["BASE_URL_RBL"], useFactory: _constants__WEBPACK_IMPORTED_MODULE_21__["baseUrlFactoryRBL"] },
                { provide: _constants__WEBPACK_IMPORTED_MODULE_21__["API_SERVER_URL_RBL"], useFactory: _constants__WEBPACK_IMPORTED_MODULE_21__["apiServerUrlFactoryRBL"] },
                _service_rblgame_service__WEBPACK_IMPORTED_MODULE_19__["RblgameService"],
                _service_rblgame_searchoptions__WEBPACK_IMPORTED_MODULE_27__["RblSearchOptionsService"],
                _chatservice_service__WEBPACK_IMPORTED_MODULE_23__["ChatService"],
                _websocket_service__WEBPACK_IMPORTED_MODULE_22__["WebsocketService"]
            ],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/app.routing.module.ts":
/*!***************************************!*\
  !*** ./src/app/app.routing.module.ts ***!
  \***************************************/
/*! exports provided: APP_ROUTES, AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "APP_ROUTES", function() { return APP_ROUTES; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm5/router.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _server_options_server_options_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./server-options/server-options.component */ "./src/app/server-options/server-options.component.ts");
/* harmony import */ var _game_card_list_game_card_list_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./game-card-list/game-card-list.component */ "./src/app/game-card-list/game-card-list.component.ts");
/* harmony import */ var _ticket_alert_ticket_alert_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./ticket-alert/ticket-alert.component */ "./src/app/ticket-alert/ticket-alert.component.ts");






var APP_ROUTES = [
    {
        path: '',
        redirectTo: 'ticketalert',
        pathMatch: 'full'
    },
    {
        path: 'games',
        component: _game_card_list_game_card_list_component__WEBPACK_IMPORTED_MODULE_4__["GameCardListComponent"]
    },
    {
        path: 'options',
        component: _server_options_server_options_component__WEBPACK_IMPORTED_MODULE_3__["ServerOptionsComponent"]
    },
    {
        path: 'ticketalert',
        component: _ticket_alert_ticket_alert_component__WEBPACK_IMPORTED_MODULE_5__["TicketAlertComponent"]
    }
];
var AppRoutingModule = /** @class */ (function () {
    function AppRoutingModule() {
    }
    AppRoutingModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(APP_ROUTES, { useHash: true })],
            exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
        })
    ], AppRoutingModule);
    return AppRoutingModule;
}());

;


/***/ }),

/***/ "./src/app/chatservice.service.ts":
/*!****************************************!*\
  !*** ./src/app/chatservice.service.ts ***!
  \****************************************/
/*! exports provided: ChatService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ChatService", function() { return ChatService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _websocket_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./websocket.service */ "./src/app/websocket.service.ts");



var CHAT_URL = 'ws://echo.websocket.org/';
// export interface Message {
//   author: string,
//   message: string
// }
var ChatService = /** @class */ (function () {
    function ChatService(wsService) {
        this.messages = wsService
            .connect(CHAT_URL)
            .map(function (response) {
            var data = JSON.parse(response.data);
            console.log('responseData:', data);
            return data;
        });
    }
    ChatService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_websocket_service__WEBPACK_IMPORTED_MODULE_2__["WebsocketService"]])
    ], ChatService);
    return ChatService;
}());



/***/ }),

/***/ "./src/app/constants.ts":
/*!******************************!*\
  !*** ./src/app/constants.ts ***!
  \******************************/
/*! exports provided: Constants, BASE_URL_RBL, baseUrlFactoryRBL, API_SERVER_URL_RBL, apiServerUrlFactoryRBL, ETAG_CACHE_LIFETIME */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Constants", function() { return Constants; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "BASE_URL_RBL", function() { return BASE_URL_RBL; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "baseUrlFactoryRBL", function() { return baseUrlFactoryRBL; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "API_SERVER_URL_RBL", function() { return API_SERVER_URL_RBL; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "apiServerUrlFactoryRBL", function() { return apiServerUrlFactoryRBL; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ETAG_CACHE_LIFETIME", function() { return ETAG_CACHE_LIFETIME; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../environments/environment */ "./src/environments/environment.ts");
/* tslint:disable */


var Constants = /** @class */ (function () {
    function Constants() {
    }
    Constants.ETAG_CACHE_LIFETIME = 120000;
    Constants.DEFAULT_TENANT = 'guest';
    Constants.API_SERVER_URL_LOCAL = "http://185.162.251.243:9123/api/v1/tenants/" + Constants.DEFAULT_TENANT;
    Constants.API_SERVER_URL_PAAS = "http://185.162.251.243:9123/api/v1/tenants/" + Constants.DEFAULT_TENANT;
    Constants.API_BASE_URL_LOCAL = "http://185.162.251.243:9123/api/v1/tenants/" + Constants.DEFAULT_TENANT;
    Constants.API_BASE_URL_PAAS = "http://185.162.251.243:9123/api/v1/tenants/" + Constants.DEFAULT_TENANT;
    return Constants;
}());

/* tslint:enable */
var BASE_URL_RBL = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('baseUrl');
function baseUrlFactoryRBL() {
    return _environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production ? Constants.API_BASE_URL_PAAS : Constants.API_BASE_URL_LOCAL;
}
var API_SERVER_URL_RBL = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('apiServerUrl');
function apiServerUrlFactoryRBL() {
    return _environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production ? Constants.API_SERVER_URL_PAAS : Constants.API_SERVER_URL_LOCAL;
}
var ETAG_CACHE_LIFETIME = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["InjectionToken"]('etagCacheLifetime');


/***/ }),

/***/ "./src/app/game-card-list/game-card-list.component.css":
/*!*************************************************************!*\
  !*** ./src/app/game-card-list/game-card-list.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "mat-sidenav-container, mat-sidenav-content, mat-sidenav {\n  height: 100%;\n}\n\nmat-sidenav {\n  width: 250px;\n}\n\na {\n  text-decoration: none;\n  color: white;\n}\n\na:hover,\na:active {\n  color: lightgray;\n}\n\n.navigation-items {\n  list-style: none;\n  padding: 0;\n  margin: 0;\n  cursor: pointer;\n}\n\n.icon {\n  height: 30px;\n  vertical-align: middle;\n}\n\n.label {\n  display: inline-block;\n  line-height: 30px;\n  margin: 0;\n  width: 85%;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZ2FtZS1jYXJkLWxpc3QvZ2FtZS1jYXJkLWxpc3QuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTtFQUNFLGFBQWE7Q0FDZDs7QUFFRDtFQUNFLGFBQWE7Q0FDZDs7QUFFRDtFQUNFLHNCQUFzQjtFQUN0QixhQUFhO0NBQ2Q7O0FBRUQ7O0VBRUUsaUJBQWlCO0NBQ2xCOztBQUVEO0VBQ0UsaUJBQWlCO0VBQ2pCLFdBQVc7RUFDWCxVQUFVO0VBQ1YsZ0JBQWdCO0NBQ2pCOztBQUVEO0VBQ0UsYUFBYTtFQUNiLHVCQUF1QjtDQUN4Qjs7QUFFRDtFQUNFLHNCQUFzQjtFQUN0QixrQkFBa0I7RUFDbEIsVUFBVTtFQUNWLFdBQVc7Q0FDWiIsImZpbGUiOiJzcmMvYXBwL2dhbWUtY2FyZC1saXN0L2dhbWUtY2FyZC1saXN0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJtYXQtc2lkZW5hdi1jb250YWluZXIsIG1hdC1zaWRlbmF2LWNvbnRlbnQsIG1hdC1zaWRlbmF2IHtcbiAgaGVpZ2h0OiAxMDAlO1xufVxuXG5tYXQtc2lkZW5hdiB7XG4gIHdpZHRoOiAyNTBweDtcbn1cblxuYSB7XG4gIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcbiAgY29sb3I6IHdoaXRlO1xufVxuXG5hOmhvdmVyLFxuYTphY3RpdmUge1xuICBjb2xvcjogbGlnaHRncmF5O1xufVxuXG4ubmF2aWdhdGlvbi1pdGVtcyB7XG4gIGxpc3Qtc3R5bGU6IG5vbmU7XG4gIHBhZGRpbmc6IDA7XG4gIG1hcmdpbjogMDtcbiAgY3Vyc29yOiBwb2ludGVyO1xufVxuXG4uaWNvbiB7XG4gIGhlaWdodDogMzBweDtcbiAgdmVydGljYWwtYWxpZ246IG1pZGRsZTtcbn1cblxuLmxhYmVsIHtcbiAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xuICBsaW5lLWhlaWdodDogMzBweDtcbiAgbWFyZ2luOiAwO1xuICB3aWR0aDogODUlO1xufVxuIl19 */"

/***/ }),

/***/ "./src/app/game-card-list/game-card-list.component.html":
/*!**************************************************************!*\
  !*** ./src/app/game-card-list/game-card-list.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <div class=\"row\">\n    <div class=\"col-xs-12 col-md-6\" *ngFor=\"let element of list\">\n      <app-game-card [element]=\"element\"></app-game-card>\n    </div>\n  </div>\n</div>\n<button >Load</button>\n\n<button (click)=\"load()\" mat-button>Load</button>\n"

/***/ }),

/***/ "./src/app/game-card-list/game-card-list.component.ts":
/*!************************************************************!*\
  !*** ./src/app/game-card-list/game-card-list.component.ts ***!
  \************************************************************/
/*! exports provided: GameCardListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GameCardListComponent", function() { return GameCardListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_rblgame_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/rblgame.service */ "./src/app/service/rblgame.service.ts");
/* harmony import */ var _service_rblgame_searchoptions__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../service/rblgame.searchoptions */ "./src/app/service/rblgame.searchoptions.ts");




var GameCardListComponent = /** @class */ (function () {
    function GameCardListComponent(service, searchOptionService) {
        this.service = service;
        this.searchOptionService = searchOptionService;
        this.list = [];
        this.searchOptionList = [];
    }
    GameCardListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.list = [];
        this.service.getRBLGames()
            .then(function (games) {
            games = games.filter(function (game) {
                return (game.name.startsWith('RB'));
            });
            _this.internList = games;
            _this.addIcons();
            return _this.searchOptionService.getSearchOptions();
        })
            .then(function (searchOptions) {
            _this.searchOptionList = searchOptions;
            _this.addsearchOptionsToRblGames();
        })
            .catch(function (error) {
            console.log(error);
        });
    };
    GameCardListComponent.prototype.addsearchOptionsToRblGames = function () {
        for (var i = 0; i < this.searchOptionList.length; i++) {
            for (var j = 0; j < this.internList.length; j++) {
                if (this.internList[j].name === this.searchOptionList[i].name) {
                    this.addSektorenToGame(this.internList[j], this.searchOptionList[i].rules);
                }
            }
        }
        this.list = this.internList;
    };
    GameCardListComponent.prototype.addSektorenToGame = function (rblGame, rules) {
        for (var i = 0; i < rules.length; i++) {
            if (rblGame.sektoren === undefined) {
                rblGame.sektoren = [];
            }
            rblGame.sektoren.push(rules[i].name);
        }
    };
    GameCardListComponent.prototype.addIcons = function () {
        for (var j = 0; j < this.internList.length; j++) {
            if (this.internList[j].name.toLocaleLowerCase().indexOf('hertha') > 0) {
                this.internList[j].imagePath = 'assets\\icons\\bundesliga\\HerthaBSC.png';
            }
            else {
                this.internList[j].imagePath = 'assets\\icons\\bundesliga\\default.png';
            }
        }
    };
    GameCardListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-game-card-list',
            template: __webpack_require__(/*! ./game-card-list.component.html */ "./src/app/game-card-list/game-card-list.component.html"),
            styles: [__webpack_require__(/*! ./game-card-list.component.css */ "./src/app/game-card-list/game-card-list.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_rblgame_service__WEBPACK_IMPORTED_MODULE_2__["RblgameService"], _service_rblgame_searchoptions__WEBPACK_IMPORTED_MODULE_3__["RblSearchOptionsService"]])
    ], GameCardListComponent);
    return GameCardListComponent;
}());



/***/ }),

/***/ "./src/app/game-card/game-card.component.css":
/*!***************************************************!*\
  !*** ./src/app/game-card/game-card.component.css ***!
  \***************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = ".example-section {\n  display: flex;\n  align-content: center;\n  align-items: center;\n  height: 60px;\n}\n\n.example-margin {\n  margin: 0 10px;\n}\n\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZ2FtZS1jYXJkL2dhbWUtY2FyZC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBO0VBQ0UsY0FBYztFQUNkLHNCQUFzQjtFQUN0QixvQkFBb0I7RUFDcEIsYUFBYTtDQUNkOztBQUVEO0VBQ0UsZUFBZTtDQUNoQiIsImZpbGUiOiJzcmMvYXBwL2dhbWUtY2FyZC9nYW1lLWNhcmQuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIi5leGFtcGxlLXNlY3Rpb24ge1xuICBkaXNwbGF5OiBmbGV4O1xuICBhbGlnbi1jb250ZW50OiBjZW50ZXI7XG4gIGFsaWduLWl0ZW1zOiBjZW50ZXI7XG4gIGhlaWdodDogNjBweDtcbn1cblxuLmV4YW1wbGUtbWFyZ2luIHtcbiAgbWFyZ2luOiAwIDEwcHg7XG59XG4iXX0= */"

/***/ }),

/***/ "./src/app/game-card/game-card.component.html":
/*!****************************************************!*\
  !*** ./src/app/game-card/game-card.component.html ***!
  \****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<mat-card class=\"example-card\" style=\"margin: 5px\">\n  <mat-card-header>\n    <div mat-card-avatar class=\"example-header-image\"></div>\n    <mat-card-title>{{element.name}}</mat-card-title>\n    <mat-card-subtitle>{{element.startdate}}</mat-card-subtitle>\n    <img src=\"{{element.imagePath}}\">\n  </mat-card-header>\n  <mat-card-content>\n    <div id=\"collapser{{element.name}}\" class=\"collapse\">\n      <p class=\"text-primary\">\n        Anzahl Plaetze: {{element.countSitzplaetze}}<br>\n        Anzahl B-Block: {{element.countBBlock}}<br>\n        Anzahl D-Block: {{element.countDBlock}}<br>\n      </p>\n      <section class=\"example-section\">\n        <mat-checkbox class=\"example-margin\" [(ngModel)]=\"sektorA\" (change)=\"checkValue('A',element.name)\">Sektor A</mat-checkbox>\n        <mat-checkbox class=\"example-margin\" [(ngModel)]=\"sektorB\" (change)=\"checkValue('B',element.name)\">Sektor B</mat-checkbox>\n        <mat-checkbox class=\"example-margin\" [(ngModel)]=\"sektorC\" (change)=\"checkValue('C',element.name)\">Sektor C</mat-checkbox>\n        <mat-checkbox class=\"example-margin\" [(ngModel)]=\"sektorD\" (change)=\"checkValue('D',element.name)\">Sektor D</mat-checkbox>\n      </section>\n    </div>\n  </mat-card-content>\n  <mat-card-actions>\n    <div class=\"row\">\n      <a class=\"col-xs-2\" mat-button href=\"#collapser{{element.name}}\" data-toggle=\"collapse\">SHOW MORE</a>\n    </div>\n  </mat-card-actions>\n</mat-card>\n"

/***/ }),

/***/ "./src/app/game-card/game-card.component.ts":
/*!**************************************************!*\
  !*** ./src/app/game-card/game-card.component.ts ***!
  \**************************************************/
/*! exports provided: GameCardComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GameCardComponent", function() { return GameCardComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_rblgame_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/rblgame.service */ "./src/app/service/rblgame.service.ts");



var GameCardComponent = /** @class */ (function () {
    function GameCardComponent(service) {
        this.service = service;
        this.sektorA = false;
        this.sektorB = false;
        this.sektorC = false;
        this.sektorD = false;
    }
    GameCardComponent.prototype.ngOnInit = function () {
        console.log('element: ', this.element);
        if (this.element && this.element.sektoren) {
            for (var i = 0; i < this.element.sektoren.length; i++) {
                if (this.element.sektoren[i].startsWith('Sektor A')) {
                    this.sektorA = true;
                }
                if (this.element.sektoren[i].startsWith('Sektor B')) {
                    this.sektorB = true;
                }
                if (this.element.sektoren[i].startsWith('Sektor C')) {
                    this.sektorC = true;
                }
                if (this.element.sektoren[i].startsWith('Sektor D')) {
                    this.sektorD = true;
                }
            }
        }
    };
    GameCardComponent.prototype.checkValue = function (sektor, game) {
        if (sektor === 'A') {
            console.log(game + ' ' + sektor, this.sektorA);
            this.sendData(sektor, game, this.sektorA);
        }
        if (sektor === 'B') {
            console.log(game + ' ' + sektor, this.sektorB);
            this.sendData(sektor, game, this.sektorB);
        }
        if (sektor === 'C') {
            console.log(game + ' ' + sektor, this.sektorC);
            this.sendData(sektor, game, this.sektorC);
        }
        if (sektor === 'D') {
            console.log(game + ' ' + sektor, this.sektorD);
            this.sendData(sektor, game, this.sektorD);
        }
    };
    GameCardComponent.prototype.sendData = function (sektor, game, active) {
        var rblGameToSearch = {
            name: game,
            sektor: sektor,
            aktiv: active
        };
        this.service.sendSearchOption(rblGameToSearch)
            .then(function () {
            console.log('saved', rblGameToSearch);
        })
            .catch(function (error) {
            console.log('error:', error);
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Object)
    ], GameCardComponent.prototype, "element", void 0);
    GameCardComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-game-card',
            template: __webpack_require__(/*! ./game-card.component.html */ "./src/app/game-card/game-card.component.html"),
            styles: [__webpack_require__(/*! ./game-card.component.css */ "./src/app/game-card/game-card.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_rblgame_service__WEBPACK_IMPORTED_MODULE_2__["RblgameService"]])
    ], GameCardComponent);
    return GameCardComponent;
}());



/***/ }),

/***/ "./src/app/menu/menu.component.css":
/*!*****************************************!*\
  !*** ./src/app/menu/menu.component.css ***!
  \*****************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL21lbnUvbWVudS5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/menu/menu.component.html":
/*!******************************************!*\
  !*** ./src/app/menu/menu.component.html ***!
  \******************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--Header-->\n<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n  <div class=\"container\">\n    <a class=\"navbar-brand\" href=\"#\">Version {{service.version}}</a>\n    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n            aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n      <span class=\"navbar-toggler-icon\"></span>\n    </button>\n    <!--Menue der collapsed wird-->\n    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n      <ul class=\"navbar-nav mr-auto\">\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" routerLink=\"/options\">Options</a>\n        </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" routerLink=\"/games\">Spiele</a>\n        </li>\n        <li class=\"nav-item\">\n          <a class=\"nav-link\" routerLink=\"/ticketalert\">Ticketalarm</a>\n        </li>\n      </ul>\n      <ul class=\"navbar-nav\">\n        <li class=\"nav-item\" >\n          <button mat-button color=\"primary\">Login</button>\n        </li>\n      </ul>\n    </div>\n  </div>\n</nav>\n\n"

/***/ }),

/***/ "./src/app/menu/menu.component.ts":
/*!****************************************!*\
  !*** ./src/app/menu/menu.component.ts ***!
  \****************************************/
/*! exports provided: MenuComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenuComponent", function() { return MenuComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _GlobalSettings__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../GlobalSettings */ "./src/app/GlobalSettings.ts");
/* harmony import */ var _service_rblgame_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../service/rblgame.service */ "./src/app/service/rblgame.service.ts");




var MenuComponent = /** @class */ (function () {
    function MenuComponent(service) {
        this.service = service;
        this.menueIds = [
            'Menue1',
            'Menue2',
            'Menue3',
            'Menue4',
        ];
    }
    MenuComponent.prototype.ngOnInit = function () {
        this.removeAllActiveClasses();
        if (_GlobalSettings__WEBPACK_IMPORTED_MODULE_2__["GlobalSettings"].MENUEEINTRAG === '') {
            _GlobalSettings__WEBPACK_IMPORTED_MODULE_2__["GlobalSettings"].MENUEEINTRAG = this.menueIds[0];
        }
        var element = document.getElementById(_GlobalSettings__WEBPACK_IMPORTED_MODULE_2__["GlobalSettings"].MENUEEINTRAG);
        if (element && element.classList) {
            element.classList.add('active');
        }
    };
    MenuComponent.prototype.removeAllActiveClasses = function () {
        this.menueIds.forEach(function (id) {
            var element = document.getElementById(id);
            if (element && element.classList) {
                element.classList.remove('active');
            }
        });
    };
    MenuComponent.prototype.setCheckedMenueItem = function (value) {
        this.removeAllActiveClasses();
        _GlobalSettings__WEBPACK_IMPORTED_MODULE_2__["GlobalSettings"].MENUEEINTRAG = value;
        console.log('Menue:', _GlobalSettings__WEBPACK_IMPORTED_MODULE_2__["GlobalSettings"].MENUEEINTRAG);
        var element = document.getElementById(_GlobalSettings__WEBPACK_IMPORTED_MODULE_2__["GlobalSettings"].MENUEEINTRAG);
        if (element && element.classList) {
            element.classList.add('active');
        }
    };
    MenuComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-menu',
            template: __webpack_require__(/*! ./menu.component.html */ "./src/app/menu/menu.component.html"),
            styles: [__webpack_require__(/*! ./menu.component.css */ "./src/app/menu/menu.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_rblgame_service__WEBPACK_IMPORTED_MODULE_3__["RblgameService"]])
    ], MenuComponent);
    return MenuComponent;
}());



/***/ }),

/***/ "./src/app/paypal-button/paypal-button.component.css":
/*!***********************************************************!*\
  !*** ./src/app/paypal-button/paypal-button.component.css ***!
  \***********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3BheXBhbC1idXR0b24vcGF5cGFsLWJ1dHRvbi5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/paypal-button/paypal-button.component.html":
/*!************************************************************!*\
  !*** ./src/app/paypal-button/paypal-button.component.html ***!
  \************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<ngx-paypal [config]=\"payPalConfig\"></ngx-paypal>\n"

/***/ }),

/***/ "./src/app/paypal-button/paypal-button.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/paypal-button/paypal-button.component.ts ***!
  \**********************************************************/
/*! exports provided: PaypalButtonComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "PaypalButtonComponent", function() { return PaypalButtonComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var ngx_paypal__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ngx-paypal */ "./node_modules/ngx-paypal/fesm5/ngx-paypal.js");



var PaypalButtonComponent = /** @class */ (function () {
    function PaypalButtonComponent() {
    }
    PaypalButtonComponent.prototype.ngOnInit = function () {
        this.initConfig();
        this.kosten = 0;
    };
    PaypalButtonComponent.prototype.initConfig = function () {
        this.payPalConfig = new ngx_paypal__WEBPACK_IMPORTED_MODULE_2__["PayPalConfig"](ngx_paypal__WEBPACK_IMPORTED_MODULE_2__["PayPalIntegrationType"].ClientSideREST, ngx_paypal__WEBPACK_IMPORTED_MODULE_2__["PayPalEnvironment"].Sandbox, {
            commit: true,
            client: {
                sandbox: 'ASFvX32sNKuWCc06qEla6jwEVZ8oufnRJaMwxDirl-b9IGVYtwfkDwYrn6kiUsp0HKhPqFQDwJnqNIy3',
            },
            button: {
                label: 'paypal',
            },
            onPaymentComplete: function (data, actions) {
                console.log('OnPaymentComplete');
            },
            onCancel: function (data, actions) {
                console.log('OnCancel');
            },
            onError: function (err) {
                console.log('OnError');
            },
            transactions: [{
                    amount: {
                        currency: 'USD',
                        total: this.kosten
                    }
                }]
        });
    };
    tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:type", Number)
    ], PaypalButtonComponent.prototype, "kosten", void 0);
    PaypalButtonComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-paypal-button',
            template: __webpack_require__(/*! ./paypal-button.component.html */ "./src/app/paypal-button/paypal-button.component.html"),
            styles: [__webpack_require__(/*! ./paypal-button.component.css */ "./src/app/paypal-button/paypal-button.component.css")]
        })
    ], PaypalButtonComponent);
    return PaypalButtonComponent;
}());



/***/ }),

/***/ "./src/app/server-options/server-options.component.css":
/*!*************************************************************!*\
  !*** ./src/app/server-options/server-options.component.css ***!
  \*************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3NlcnZlci1vcHRpb25zL3NlcnZlci1vcHRpb25zLmNvbXBvbmVudC5jc3MifQ== */"

/***/ }),

/***/ "./src/app/server-options/server-options.component.html":
/*!**************************************************************!*\
  !*** ./src/app/server-options/server-options.component.html ***!
  \**************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"row\">\n  <h1>Server-Status: {{status}}</h1>\n  <button class=\"col-xs-4\" mat-button (click)=\"callStartService()\">Start</button>\n  <button class=\"col-xs-4\" mat-button (click)=\"callStopService()\">Stop</button>\n</div>\n"

/***/ }),

/***/ "./src/app/server-options/server-options.component.ts":
/*!************************************************************!*\
  !*** ./src/app/server-options/server-options.component.ts ***!
  \************************************************************/
/*! exports provided: ServerOptionsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ServerOptionsComponent", function() { return ServerOptionsComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _service_rblgame_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../service/rblgame.service */ "./src/app/service/rblgame.service.ts");



var ServerOptionsComponent = /** @class */ (function () {
    function ServerOptionsComponent(service) {
        this.service = service;
        this.status = '';
    }
    ServerOptionsComponent.prototype.ngOnInit = function () {
    };
    ServerOptionsComponent.prototype.callStartService = function () {
        var _this = this;
        this.service.startServer().then(function (serverstatus) {
            _this.status = serverstatus.status;
            console.log('status:', serverstatus);
        }).catch(function (error) {
            console.log('error:', error);
            _this.status = error;
        });
    };
    ServerOptionsComponent.prototype.callStopService = function () {
        var _this = this;
        this.service.stopServer().then(function (serverstatus) {
            _this.status = serverstatus.status;
            console.log('status:', serverstatus);
        }).catch(function (error) {
            console.log('error:', error);
            _this.status = error;
        });
    };
    ServerOptionsComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-server-options',
            template: __webpack_require__(/*! ./server-options.component.html */ "./src/app/server-options/server-options.component.html"),
            styles: [__webpack_require__(/*! ./server-options.component.css */ "./src/app/server-options/server-options.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_rblgame_service__WEBPACK_IMPORTED_MODULE_2__["RblgameService"]])
    ], ServerOptionsComponent);
    return ServerOptionsComponent;
}());



/***/ }),

/***/ "./src/app/service/rblgame.searchoptions.ts":
/*!**************************************************!*\
  !*** ./src/app/service/rblgame.searchoptions.ts ***!
  \**************************************************/
/*! exports provided: RblSearchOptionsService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RblSearchOptionsService", function() { return RblSearchOptionsService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _constants__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../constants */ "./src/app/constants.ts");




var RblSearchOptionsService = /** @class */ (function () {
    function RblSearchOptionsService(http, apiBasePath, apiServerUrl) {
        this.http = http;
        this.apiBasePath = apiBasePath;
        this.apiServerUrl = apiServerUrl;
        this.MODULE_ID_FOR_ETAGS = 'INVENTORYTROUBLE';
        this.showAsWarning = false;
    }
    RblSearchOptionsService.prototype.getRBLGameNames = function () {
        return this.http.get(this.apiServerUrl + '/gamenames').toPromise();
    };
    RblSearchOptionsService.prototype.getSearchOptions = function () {
        return this.http.get(this.apiServerUrl + '/searchoptions').toPromise();
    };
    RblSearchOptionsService.prototype.setSearchOptions = function (searchOption) {
        return this.http.put(this.apiServerUrl + '/searchoptionschange', searchOption).toPromise();
    };
    RblSearchOptionsService.prototype.getRules = function () {
        return this.http.get(this.apiServerUrl + '/rule').toPromise();
    };
    RblSearchOptionsService.prototype.getClassForRuleName = function (gameName, rule) {
        return 'btn btn-success btn-lg';
    };
    RblSearchOptionsService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_constants__WEBPACK_IMPORTED_MODULE_3__["BASE_URL_RBL"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](2, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_constants__WEBPACK_IMPORTED_MODULE_3__["API_SERVER_URL_RBL"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], Object, Object])
    ], RblSearchOptionsService);
    return RblSearchOptionsService;
}());



/***/ }),

/***/ "./src/app/service/rblgame.service.ts":
/*!********************************************!*\
  !*** ./src/app/service/rblgame.service.ts ***!
  \********************************************/
/*! exports provided: RblgameService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "RblgameService", function() { return RblgameService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _constants__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../constants */ "./src/app/constants.ts");




var RblgameService = /** @class */ (function () {
    function RblgameService(http, apiBasePath, apiServerUrl) {
        this.http = http;
        this.apiBasePath = apiBasePath;
        this.apiServerUrl = apiServerUrl;
        this.version = '0.0';
        this.MODULE_ID_FOR_ETAGS = 'INVENTORYTROUBLE';
    }
    RblgameService.prototype.getRBLGames = function () {
        return this.http.get(this.apiBasePath + '/rblgames').toPromise();
    };
    RblgameService.prototype.getRBLGameVerlauf = function () {
        return this.http.get(this.apiBasePath + '/rblgamesverlauf').toPromise();
    };
    RblgameService.prototype.startServer = function () {
        return this.http.get(this.apiBasePath + '/rblschedule/start').toPromise();
    };
    RblgameService.prototype.stopServer = function () {
        return this.http.get(this.apiBasePath + '/rblschedule/stop').toPromise();
    };
    RblgameService.prototype.sendSearchOption = function (rblGameToSearch) {
        return this.http.post(this.apiBasePath + '/gametosearch', rblGameToSearch).toPromise();
    };
    RblgameService.prototype.getLastUserData = function () {
        return this.http.get(this.apiBasePath + '/username').toPromise();
    };
    RblgameService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](1, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_constants__WEBPACK_IMPORTED_MODULE_3__["BASE_URL_RBL"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__param"](2, Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Inject"])(_constants__WEBPACK_IMPORTED_MODULE_3__["API_SERVER_URL_RBL"])),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"], Object, Object])
    ], RblgameService);
    return RblgameService;
}());



/***/ }),

/***/ "./src/app/ticket-alert/ticket-alert.component.css":
/*!*********************************************************!*\
  !*** ./src/app/ticket-alert/ticket-alert.component.css ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3RpY2tldC1hbGVydC90aWNrZXQtYWxlcnQuY29tcG9uZW50LmNzcyJ9 */"

/***/ }),

/***/ "./src/app/ticket-alert/ticket-alert.component.html":
/*!**********************************************************!*\
  !*** ./src/app/ticket-alert/ticket-alert.component.html ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <section class=\"content\">\n    <div class=\"card\" style=\"margin-top: 5px\">\n      <div class=\"card-header\">\n        {{getDateFromServer()}}\n        <span class=\"badge badge-success\" style=\"margin:2px;\" *ngIf=\"status === true\">Server started</span>\n        <span class=\"badge badge-success\" style=\"margin:2px;\" *ngIf=\"statusWebSocket === true\">WS connected</span>\n        <span class=\"badge badge-danger\" style=\"margin:2px;\" *ngIf=\"status === false\">Server stopped</span>\n        <span class=\"badge badge-danger\" style=\"margin:2px;\" *ngIf=\"statusWebSocket === false\">WS disconnected</span>\n        <button type=\"button\" class=\"btn btn-outline-primary btn-sm\" *ngIf=\"!status\" (click)=\"callStartService()\">Start</button>\n        <button type=\"button\" class=\"btn btn-outline-primary btn-sm\" *ngIf=\"status\" (click)=\"callStopService()\">Stop</button>\n        <button type=\"button\" class=\"btn btn-outline-primary btn-sm\" *ngIf=\"disabled\" (click)=\"connect()\">Connect</button>\n        <button type=\"button\" class=\"btn btn-outline-primary btn-sm\" *ngIf=\"!disabled\" (click)=\"disconnect()\">Disconnect</button>\n        <button type=\"button\" class=\"btn btn-outline-success btn-sm\" (click)=\"clearList()\">Clear</button>\n        <button type=\"button\" class=\"btn btn-outline-success btn-sm\" (click)=\"silence()\">Stille</button>\n        {{getPureDateFromServer()}}\n      </div>\n      <div class=\"card-body\">\n        <div class=\"card-text\">\n        <p *ngIf=\"waitroomcounter.counter > 0\">Warteraum: {{waitroomcounter.counter}}</p>\n        </div>\n        <div id=\"accordion\">\n          <div class=\"card\" style=\"margin-top: 5px\">\n            <div class=\"card-header\">\n              Suchergebnisse\n            </div>\n            <div class=\"card-body\">\n\n              <div class=\"list-group col-lg-12\">\n                <div class=\"col-lg-12\" *ngFor=\"let game of rblRuleResults\">\n                  <a href=\"{{game.link}}\" target=\"_blank\" class=\"list-group-item list-group-item-action\">\n                    <h3 class=\"col-lg-12\">\n                      {{game.Name}}\n                    </h3>\n                    <p class=\"col-lg-6 col-sm-12\">\n                      {{game.sitzplatz.kategorie}} {{game.Info}}\n                    </p>\n                    <p class=\"col-lg-4 col-sm-12\">\n                      {{game.sitzplatz.bereich}} {{game.sitzplatz.reihe}} {{game.sitzplatz.sitz}}\n                    </p>\n                  </a>\n                </div>\n              </div>\n            </div>\n          </div>\n\n        </div>\n\n      </div>\n    </div>\n    <div class=\"card\">\n      <div class=\"card-header\" id=\"headingThree\">\n        <h5 class=\"mb-0\">\n          <button class=\"btn btn-link collapsed\" data-toggle=\"collapse\" data-target=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">\n            Games\n          </button>\n        </h5>\n      </div>\n      <div id=\"collapseThree\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordion\">\n        <div class=\"card-body\">\n          <div *ngFor=\"let option of searchOptionConatiner.scanedGames\">\n            <a href=\"{{option.link}}\" target=\"_blank\">{{option.name}} {{option.plaetze.length}} freie Plätze</a>\n          </div>\n        </div>\n      </div>\n    </div>\n    <div class=\"card\">\n      <div class=\"card-header\" id=\"headingTwo\">\n        <h5 class=\"mb-0\">\n          <button class=\"btn btn-link collapsed\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">\n            SearchOptions\n          </button>\n        </h5>\n      </div>\n      <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordion\">\n        <div class=\"card-body\">\n          <div *ngFor=\"let option of searchOptionConatiner.searchOptions\">\n            {{option.name}}\n            <div *ngFor=\"let rule of option.rules\">\n              {{rule.name}}\n            </div>\n          </div>\n        </div>\n      </div>\n    </div>\n  </section>\n</div>\n\n"

/***/ }),

/***/ "./src/app/ticket-alert/ticket-alert.component.ts":
/*!********************************************************!*\
  !*** ./src/app/ticket-alert/ticket-alert.component.ts ***!
  \********************************************************/
/*! exports provided: TicketAlertComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TicketAlertComponent", function() { return TicketAlertComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var stompjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! stompjs */ "./node_modules/stompjs/index.js");
/* harmony import */ var stompjs__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(stompjs__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var sockjs_client__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! sockjs-client */ "./node_modules/sockjs-client/lib/entry.js");
/* harmony import */ var sockjs_client__WEBPACK_IMPORTED_MODULE_3___default = /*#__PURE__*/__webpack_require__.n(sockjs_client__WEBPACK_IMPORTED_MODULE_3__);
/* harmony import */ var _websocket_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../websocket.service */ "./src/app/websocket.service.ts");
/* harmony import */ var _chatservice_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../chatservice.service */ "./src/app/chatservice.service.ts");
/* harmony import */ var _service_rblgame_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../service/rblgame.service */ "./src/app/service/rblgame.service.ts");







var TicketAlertComponent = /** @class */ (function () {
    function TicketAlertComponent(service) {
        this.service = service;
        this.title = 'Ticket Ale1rt';
        this.description = 'Ticketalert für alle aktiven Spiele';
        this.version = '3.2';
        this.rblRuleResults = [];
        this.status = true;
        this.statusWebSocket = false;
        this.stompClient = null;
        this.audio = new Audio();
        this.playingMusic = false;
        this.userName = '';
        this.waitroomcounter = {
            counter: -1
        };
        this.disabled = true;
        this.searchOptionConatiner = {
            searchOptions: [],
            scanedGames: []
        };
        this.service.version = this.version;
        // this.setDummyData();
    }
    TicketAlertComponent.prototype.ngOnInit = function () {
    };
    TicketAlertComponent.prototype.setConnected = function (connected) {
        this.disabled = !connected;
        this.statusWebSocket = connected;
        if (connected) {
            this.rblRuleResults = [];
        }
    };
    TicketAlertComponent.prototype.connect = function () {
        //let socket = new SockJS('http://localhost:9123/websocket-example');
        var socket = new sockjs_client__WEBPACK_IMPORTED_MODULE_3__('http://185.162.251.243:9123/websocket-example');
        this.stompClient = stompjs__WEBPACK_IMPORTED_MODULE_2__["over"](socket);
        var _this = this;
        this.stompClient.connect({}, function (frame) {
            _this.setConnected(true);
            _this.stompClient.subscribe('/topic/user', function (hello) {
                _this.showWebSocketResult(JSON.parse(hello.body).content);
            });
            _this.stompClient.subscribe('/topic/searchoptions', function (searchoptions) {
                _this.showSearchoptionsResult(JSON.parse(searchoptions.body).content);
                _this.service.getLastUserData().then(function (userName) {
                    _this.userName = userName;
                }).catch(function () {
                    _this.userName = 'Fehler';
                });
            });
            _this.stompClient.subscribe('/topic/waitroomcounter', function (waitroomcounter) {
                _this.showWaitroomCounter(JSON.parse(waitroomcounter.body).content);
            });
        });
    };
    TicketAlertComponent.prototype.disconnect = function () {
        if (this.stompClient != null) {
            this.stompClient.disconnect();
        }
        this.setConnected(false);
        console.log('Disconnected!');
    };
    TicketAlertComponent.prototype.showWebSocketResult = function (message) {
        console.log('showWebSocketResult: ', message);
        window.navigator.vibrate(200); // vibrate for 200ms
        this.sound();
        this.rblRuleResults.push(message);
    };
    TicketAlertComponent.prototype.showSearchoptionsResult = function (result) {
        console.log('showSearchoptionsResult: ', result);
        this.searchOptionConatiner = result;
    };
    TicketAlertComponent.prototype.showWaitroomCounter = function (result) {
        console.log('waitrooom', result);
        this.waitroomcounter = result;
    };
    TicketAlertComponent.prototype.clearList = function () {
        this.rblRuleResults = [];
        this.searchOptionConatiner = {
            searchOptions: [],
            scanedGames: []
        };
    };
    TicketAlertComponent.prototype.callStartService = function () {
        var _this_1 = this;
        this.service.startServer().then(function (serverstatus) {
            _this_1.status = true;
        }).catch(function (error) {
            _this_1.status = false;
            console.log('error:', error);
        });
    };
    TicketAlertComponent.prototype.callStopService = function () {
        var _this_1 = this;
        this.service.stopServer().then(function (serverstatus) {
            _this_1.status = false;
        }).catch(function (error) {
            _this_1.status = true;
            console.log('error:', error);
        });
    };
    TicketAlertComponent.prototype.sound = function () {
        var _this_1 = this;
        if (this.playingMusic === false) {
            this.playingMusic = true;
            this.audio.src = '../assets/police.mp3';
            this.audio.load();
            this.audio.play().then(function () {
                _this_1.playingMusic = false;
            }).catch(function () {
                _this_1.playingMusic = false;
            });
        }
    };
    TicketAlertComponent.prototype.silence = function () {
        if (this.audio) {
            this.audio.pause();
            this.playingMusic = false;
        }
    };
    TicketAlertComponent.prototype.getDateFromServer = function () {
        if (this.searchOptionConatiner && this.searchOptionConatiner.date) {
            var date = new Date(this.searchOptionConatiner.date);
            return date.toLocaleTimeString();
        }
        return 'kein Datum verfügbar';
    };
    TicketAlertComponent.prototype.getPureDateFromServer = function () {
        if (this.searchOptionConatiner && this.searchOptionConatiner.date) {
            return this.searchOptionConatiner.date;
        }
        return '';
    };
    TicketAlertComponent.prototype.setDummyData = function () {
        var result = {
            Check: true,
            Info: '2 22 22',
            sitzplatz: {
                bereich: '1',
                reihe: '12',
                sitz: '2',
                kategorie: '33'
            },
            link: 'http://www.google.de',
            Name: 'RB Leipzig - SC Münchaurach'
        };
        this.rblRuleResults.push(result);
        this.rblRuleResults.push(result);
        this.rblRuleResults.push(result);
        this.rblRuleResults.push(result);
    };
    TicketAlertComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-ticket-alert',
            template: __webpack_require__(/*! ./ticket-alert.component.html */ "./src/app/ticket-alert/ticket-alert.component.html"),
            providers: [_websocket_service__WEBPACK_IMPORTED_MODULE_4__["WebsocketService"], _chatservice_service__WEBPACK_IMPORTED_MODULE_5__["ChatService"]],
            styles: [__webpack_require__(/*! ./ticket-alert.component.css */ "./src/app/ticket-alert/ticket-alert.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_service_rblgame_service__WEBPACK_IMPORTED_MODULE_6__["RblgameService"]])
    ], TicketAlertComponent);
    return TicketAlertComponent;
}());



/***/ }),

/***/ "./src/app/websocket.service.ts":
/*!**************************************!*\
  !*** ./src/app/websocket.service.ts ***!
  \**************************************/
/*! exports provided: WebsocketService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WebsocketService", function() { return WebsocketService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var rxjs_Rx__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs/Rx */ "./node_modules/rxjs-compat/_esm5/Rx.js");



var WebsocketService = /** @class */ (function () {
    function WebsocketService() {
    }
    WebsocketService.prototype.connect = function (url) {
        if (!this.subject) {
            this.subject = this.create(url);
            console.log("Successfully connected: " + url);
        }
        return this.subject;
    };
    WebsocketService.prototype.create = function (url) {
        var ws = new WebSocket(url);
        var observable = rxjs_Rx__WEBPACK_IMPORTED_MODULE_2__["Observable"].create(function (obs) {
            ws.onmessage = obs.next.bind(obs);
            ws.onerror = obs.error.bind(obs);
            ws.onclose = obs.complete.bind(obs);
            return ws.close.bind(ws);
        });
        var observer = {
            next: function (data) {
                if (ws.readyState === WebSocket.OPEN) {
                    ws.send(JSON.stringify(data));
                }
            }
        };
        return rxjs_Rx__WEBPACK_IMPORTED_MODULE_2__["Subject"].create(observer, observable);
    };
    WebsocketService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])(),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], WebsocketService);
    return WebsocketService;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! hammerjs */ "./node_modules/hammerjs/hammer.js");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(hammerjs__WEBPACK_IMPORTED_MODULE_4__);





if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/lutz/IdeaProjects/rblscannerclient/src/main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map