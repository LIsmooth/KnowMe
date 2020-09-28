const KM = require('../../utils/KMAPI.js');
const app = getApp()

Page({
    data: {
        isIphoneX: app.globalData.isIphoneX,
        size: 1,
        items: [],
        todos: [],
        pageMetaScrollTop: 0,
        scrollTop: 0
    },
    createSchedule(e) {
        console.log(this.drag.data.list);
    },
    sortEnd(e) {
        console.log("sortEnd", e.detail.listData)
        this.setData({
            items: e.detail.listData
        });
    },
    change(e) {
        console.log("change", e.detail.listData)
    },
    sizeChange(e) {
        wx.pageScrollTo({scrollTop: 0})
        this.setData({
            size: e.detail.value
        });
        this.drag.init();
    },
    itemClick(e) {
        let currData = e.detail.data;
        this.clickOne(this.data.items, this.data.todos, currData);
    },
    todoClick(e) {
        let currData = e.currentTarget.dataset.detail;
        this.clickOne(this.data.todos, this.data.items, currData);
    },
    clickOne(fromArr, toArr, d) {
        wx.vibrateShort();
        this.removeElement(fromArr, d);
        toArr.push(d);
        this.setData({
            items: this.data.items,
            todos: this.data.todos
        });
        this.drag.init();
    },
    removeElement(arr, e) {
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].todoId === e.todoId) {
                arr.splice(i, 1);
                return;
            }
        }
    },
    // toggleFixed(e) {
    //     let key = e.currentTarget.dataset.key;
    //
    //     let {items} = this.data;
    //
    //     items[key].fixed = !items[key].fixed
    //
    //     this.setData({
    //         items: items
    //     });
    //     this.drag.init();
    // },

    scroll(e) {
        this.setData({
            pageMetaScrollTop: e.detail.scrollTop
        })
    },
    // 页面滚动
    onPageScroll(e) {
        this.setData({
            scrollTop: e.scrollTop
        });
    },
    onPullDownRefresh: function () {
        this.setData({
            items:[]
        })
        this.onLoad();
        wx.stopPullDownRefresh()
    },
    onLoad() {
        this.drag = this.selectComponent('#drag');
        let params = {aid: app.globalData.aid, status: 0};
        let _this = this
        KM.get_todos(params).then(function (res) {
            if (res.code !== 0) {
                wx.showModal({
                    title: '无法登录',
                    content: res.errorMsg,
                    showCancel: false
                })
            }
            _this.setData({
                todos: res.data.todos
            });
        });
        this.drag.init();
    }
})
