package cn.edu.hebut.ego.common;//package cn.edu.hebut.assistant.common;
//
//import com.alibaba.excel.metadata.Head;
//import com.alibaba.excel.write.merge.AbstractMergeStrategy;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.util.CellRangeAddress;
//
//import java.util.List;
//
///**
// * excel导出工具
// * easyexcel
// */
//public class MyMergeStrategy extends AbstractMergeStrategy {
//    @Override
//    protected void merge(Sheet sheet, Cell cell, Head head, Integer relativeRowIndex) {
//
//    }
////
////    private List<LedgerCheckOutVo> ledgerCheckOutVos;
////    private List<Integer> mergeList;
////    private Sheet sheet;
////
////    public MyMergeStrategy(List<LedgerCheckOutVo> ledgerCheckOutVos, List<Integer> mergeList) {
////        this.ledgerCheckOutVos = ledgerCheckOutVos;
////        this.mergeList = mergeList;
////    }
////
////    // 将该列全部合并成一个单元格
////    private void mergeCommonColumn(Integer index) {
////        CellRangeAddress cellRangeAddress = new CellRangeAddress(1, ledgerCheckOutVos.size(), index, index);
////        sheet.addMergedRegionUnsafe(cellRangeAddress);
////    }
////
////    // 按照分组将各种类别分别合并成一个单元格
////    private void mergeGroupColumn(Integer index) {
////        Integer rowCnt = 1;
////        for (Integer count : mergeList) {
////            if (count==1){
////                rowCnt += count;
////            }else{
////                CellRangeAddress cellRangeAddress = new CellRangeAddress(rowCnt, rowCnt + count - 1 , index, index);
////                sheet.addMergedRegionUnsafe(cellRangeAddress);
////                rowCnt += count;
////            }
////
////        }
////    }
////
////    @Override
////    protected void merge(org.apache.poi.ss.usermodel.Sheet sheet, Cell cell, Head head, Integer integer) {
////        this.sheet = sheet;
////        if (cell.getRowIndex() == 1) {
////            switch (cell.getColumnIndex()) {
////                case 0:
////                    this.mergeGroupColumn(0);
////                    break;
////                case 1:
////                    this.mergeGroupColumn(1);
////                    break;
////                case 2:
////                    this.mergeGroupColumn(2);
////                    break;
////                case 3:
////                    this.mergeGroupColumn(3);
////                    break;
////                case 4:
////                    this.mergeGroupColumn(4);
////                    break;
////                case 6:
////                    this.mergeGroupColumn(6);
////                    break;
////                case 7:
////                    this.mergeGroupColumn(7);
////                    break;
////                case 8:
////                    this.mergeGroupColumn(8);
////                    break;
////                case 9:
////                    this.mergeGroupColumn(9);
////                    break;
////                case 10:
////                    this.mergeGroupColumn(10);
////                    break;
////                case 11:
////                    this.mergeGroupColumn(11);
////                    break;
////                case 12:
////                    this.mergeGroupColumn(12);
////                    break;
////                case 13:
////                    this.mergeGroupColumn(13);
////                    break;
////                case 14:
////                    this.mergeGroupColumn(14);
////                    break;
////                default:
////                    break;
////            }
////        }
////    }
//}