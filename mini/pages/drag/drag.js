const app = getApp()
let items = []
let todos = []

Page({
    data: {
        isIphoneX: app.globalData.isIphoneX,
        size: 1,
        items: [],
        todos: todos,
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
        this.clickOne(items, todos, currData);
    },
    todoClick(e) {
        let currData = e.currentTarget.dataset.detail;
        this.clickOne(todos, items, currData);
    },
    clickOne(fromArr, toArr, d) {
        wx.vibrateShort();
        this.removeElement(fromArr, d);
        toArr.push(d);
        this.setData({
            items: items,
            todos: todos
        });
        this.drag.init();
    },
    removeElement(arr, e) {
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].dragId === e.dragId) {
                arr.splice(i, 1);
                return;
            }
        }
    },
    toggleFixed(e) {
        let key = e.currentTarget.dataset.key;

        let {items} = this.data;

        items[key].fixed = !items[key].fixed

        this.setData({
            items: items
        });

        this.drag.init();
    },
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
    onLoad() {
        this.drag = this.selectComponent('#drag');

        this.setData({
            items: items
        });
        this.drag.init();
    }
})
