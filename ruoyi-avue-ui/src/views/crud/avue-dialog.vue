<template>
  <div>
    <el-dialog
               append-to-body
               :title="dialogOption.title || '弹窗操作'"
               :width="dialogOption.width || '50%'"
               :top="dialogOption.top || '50px' "
               :visible="showDialogProps"
               width="60%" @close='closeDialog'>
      <avue-form ref="form" :value.sync="objectData" :option="formOption" @reset-change="resetForm" @submit="submit">

      </avue-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "avue-dialog",
  props: {
    // 是否显示弹层
    showDialogProps: {
      type: Boolean,
      required: false
    },
    // 展示默认值数据
    objectData: {
      type: Object,
      required: false,
      default: {}
    },
    // form的option参数
    formOption: {
      type: Object,
      required: true,
    },
    dialogOption: {
      default: {}
    }
  },
  data() {
    return {
      sizeValue: 'small'
    }
  },
  watch: {
    // 当关闭弹窗的时候，清空里面的值
    showDialogProps(val) {
      if (!val) {
        this.$refs.form.resetForm();
      }
    }
  },
  computed: {},
  mounted() {

  },
  methods: {
    resetForm() {
      this.$emit("resetForm");
    },
    submit(row, hide) {
      this.$emit("submit", row, hide);
    }, closeDialog() {
      this.$emit("closeDialog");
    }
  }
}
</script>

<style scoped>

</style>
