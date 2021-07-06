package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Exception.ChiHo_ContHangException;
import com.tiendat.demo.Exception.ChiPhiContHang_ContHangException;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.CongViecTX;
import com.tiendat.demo.ModelView.ContHangExel;
import com.tiendat.demo.Respository.*;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContHangTXCVDAO {

    @Autowired
    private ContHangTXCVRespository contHangTXCVRespository = new ContHangTXCVRespositoryImplement();

    @Autowired
    private ContHangRespository contHangRespository = new ContHangRespositoryImplement();

    @Autowired
    private LoaiChiHoContHangRespository loaiChiHoContHangRespository = new LoaiChiHoContHangRespositoryImplement();

    @Autowired
    private ChiPhiContHangContHangRespository chiPhiContHangContHangRespository = new ChiPhiContHangContHangRespositoryImplement();

    @Autowired
    private LoaiHangRespository loaiHangRespository = new LoaiHangRespositoryImplement();

    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();

    @Autowired
    private CangLayRepository cangLayRepository = new CangLayRespositoryImplement();

    @Autowired
    private CangHaRepository cangHaRepository = new CangHaRespositoryImplement();

    @Autowired
    private ChuyenHangRespository chuyenHangRespository = new ChuyenHangRespositoryImplement();

    @Autowired
    private LoaiChiHoRespository loaiChiHoRespository = new LoaiChiHoRespositoryImplement();

    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();

    @Autowired
    private CongViecTaiXeContHangRespository congViecTaiXeContHangRespository =
            new CongViecTaiXeContHangRespositoryImplement();

    @Transactional(propagation = Propagation.MANDATORY )
    public void saveDanhSachContHang(ObservableList<CongViecTX> dsCongViecTX,
                                     ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                                     ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                                     ContHang contHang) throws CV_TX_CHException, ChiHo_ContHangException, ChiPhiContHang_ContHangException {


        contHangRespository.save(contHang);


        SaveDSChiHo(dsLoaiChiHoContHangs,contHang);


        SaveDSChiPhiContHang(dsChiPhiContHangContHang,contHang);


        SaveDSCongViec(dsCongViecTX, contHang);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {CV_TX_CHException.class,ChiHo_ContHangException.class,
                    ChiPhiContHang_ContHangException.class})
    public void saveDS(ObservableList<CongViecTX> dsCongViecTX,
                       ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                       ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                       ContHang contHang) throws CV_TX_CHException, ChiHo_ContHangException,
            ChiPhiContHang_ContHangException {

        this.saveDanhSachContHang(dsCongViecTX,dsLoaiChiHoContHangs,dsChiPhiContHangContHang,contHang);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {CV_TX_CHException.class})
    public void UpdateCongViec(ObservableList<CongViecTX> dsCongViecTX,ContHang contHang) throws CV_TX_CHException {
        this.UpdateDSCongViec(dsCongViecTX,contHang);
    }

    @Transactional(propagation = Propagation.MANDATORY )
    public void UpdateDSCongViec(ObservableList<CongViecTX> dsCongViecTX,ContHang contHang) throws CV_TX_CHException {

        contHangTXCVRespository.DeleteByIdContHang(contHang.getId());
        SaveDSCongViec(dsCongViecTX, contHang);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {ChiPhiContHang_ContHangException.class})
    public void UpdateChiPhiContHang(ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                                     ContHang contHang) throws ChiPhiContHang_ContHangException {
        this.UpdateDSChiPhiContHang(dsChiPhiContHangContHang,contHang);
    }

    @Transactional(propagation = Propagation.MANDATORY )
    public void UpdateDSChiPhiContHang(ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                                       ContHang contHang) throws ChiPhiContHang_ContHangException {

        chiPhiContHangContHangRespository.DeleteByIdContHang(contHang.getId());
        SaveDSChiPhiContHang(dsChiPhiContHangContHang, contHang);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {ChiHo_ContHangException.class})
    public void UpdateChiHo(ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                            ContHang contHang) throws ChiHo_ContHangException {
        this.UpdateDSChiHo(dsLoaiChiHoContHangs,contHang);
    }

    @Transactional(propagation = Propagation.MANDATORY )
    public void UpdateDSChiHo(ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                              ContHang contHang) throws ChiHo_ContHangException {

        loaiChiHoContHangRespository.DeleteByIdContHang(contHang.getId());
        SaveDSChiHo(dsLoaiChiHoContHangs, contHang);
    }

    private void SaveDSCongViec(ObservableList<CongViecTX> dsCongViecTX, ContHang contHang) throws CV_TX_CHException {
        for(CongViecTX e : dsCongViecTX) {
            CongViec_TaiXe_ContHang congViec_taiXe_contHang = new CongViec_TaiXe_ContHang();
            congViec_taiXe_contHang.setLoaiCongViec_chuyenHang(e.getLoaiCongViec_chuyenHang());
            congViec_taiXe_contHang.setContHang(contHang);
            congViec_taiXe_contHang.setTaiXe(e.getTaiXe());

            CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK = new CongViec_TaiXe_ContHangPK();
            congViec_taiXe_contHangPK.setLoaiCongViec_ChuyenHangId(e.getLoaiCongViec_chuyenHang().getId());
            congViec_taiXe_contHangPK.setConthangid(contHang.getId());
            congViec_taiXe_contHang.setId(congViec_taiXe_contHangPK);

            if (!contHangTXCVRespository.existsById(congViec_taiXe_contHangPK))
                contHangTXCVRespository.save(congViec_taiXe_contHang);
            else {
                throw new CV_TX_CHException("Nhập Công việc 2 lần");

            }
        }
    }

    private void SaveDSChiPhiContHang(ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                                      ContHang contHang) throws ChiPhiContHang_ContHangException {
        for(ChiPhiContHang_ContHang e : dsChiPhiContHangContHang){
            ChiPhiContHang_ContHangPK chiPhiContHang_contHangPK = new ChiPhiContHang_ContHangPK();
            chiPhiContHang_contHangPK.setIdContHang(contHang.getId());
            chiPhiContHang_contHangPK.setIdChiPhiContHang(e.getLoaiChiPhiContHang().getId());

            e.setContHang(contHang);
            e.setId(chiPhiContHang_contHangPK);
            //chiPhiContHangContHangRespository.save(e);

            if(!chiPhiContHangContHangRespository.existsById(chiPhiContHang_contHangPK))
                chiPhiContHangContHangRespository.save(e);
            else{
                throw new ChiPhiContHang_ContHangException("Nhập Chi Phí 2 lần giống nhau");
            }

        }
    }

    private void SaveDSChiHo(ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                             ContHang contHang) throws ChiHo_ContHangException {
        for(LoaiChiHo_ContHang e : dsLoaiChiHoContHangs){
            LoaiChiHo_ContHangPK loaiChiHo_contHangPK = new LoaiChiHo_ContHangPK();
            loaiChiHo_contHangPK.setIdConHang(contHang.getId());
            loaiChiHo_contHangPK.setIdLoaiChiHo(e.getLoaiChiHo().getId());

            e.setContHang(contHang);
            e.setId(loaiChiHo_contHangPK);
            //loaiChiHoContHangRespository.save(e);

            if(!loaiChiHoContHangRespository.existsById(loaiChiHo_contHangPK))
                loaiChiHoContHangRespository.save(e);
            else{
                throw new ChiHo_ContHangException("Nhập Chi Hộ 2 lần giống nhau");
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {CV_TX_CHException.class})
    public void saveContHangExel(List<ContHangExel> contHangExels, ChuHang chuHang,LoaiHang loaiHang)
            throws CV_TX_CHException {
        this.saveContHang(contHangExels,chuHang,loaiHang);
    }

    @Transactional(propagation = Propagation.MANDATORY )
    public void saveContHang(List<ContHangExel> contHangExels, ChuHang chuHang, LoaiHang loaiHang) throws CV_TX_CHException {

        for (ContHangExel contHangExel : contHangExels) {
            ContHang contHang = new ContHang();
            contHang.setNgay(contHangExel.getNgay());
            contHang.setSoCont(contHangExel.getSoCont());

//            contHang = contHangRespository.save(contHang);

            CangHa cangHa = cangHaRepository.findTop1ByTen(contHangExel.getCangHa());
            if(cangHa == null){
                System.out.println("Không tìm thấy cảng hạ :" + contHangExel.getCangHa());
                throw new CV_TX_CHException("Không tìm thấy cảng hạ :" + contHangExel.getCangHa());

            }
            contHang.setCangHa(cangHa);

            CangLay cangLay = cangLayRepository.findTop1ByTen(contHangExel.getCangLay());
            if(cangLay == null){
                System.out.println("Không tìm thấy cảng Lấy:" + contHangExel.getCangLay());
                throw new CV_TX_CHException("Không tìm thấy cảng Lấy:" + contHangExel.getCangLay());
            }
            contHang.setCangLay(cangLay);

            Xe xe = xeRespository.findTop1ByBienSo(contHangExel.getSoXe());
            if(xe == null){
                System.out.println("Không tìm thấy Số xe : " + contHangExel.getSoXe());
                throw new CV_TX_CHException("Không tìm thấy Số xe : " + contHangExel.getSoXe());
            }
            contHang.setXe(xe);
            contHang.setLoaiHang(loaiHang);
            contHang = contHangRespository.save(contHang);


            ChuyenHang chuyenHang = chuyenHangRespository.findTop1ByChuHangAndTenChuyenHang(
                    chuHang,contHangExel.getChuyen());

            if(chuyenHang == null){
                System.out.println("Không tìm thấy Chuyến Hàng : " + contHangExel.getChuyen());
                throw new CV_TX_CHException("Không tìm thấy Chuyến Hàng : " + contHangExel.getChuyen());
            }

            LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang =
                    loaiCongViecChuyenHangRespository.findByNguyenChuyenHangAndChuyenHang(chuyenHang.getId());
            if(loaiCongViec_chuyenHang == null){
                System.out.println("Chưa Có Công Việc Nguyên Chuyến Hàng của : " + contHangExel.getChuyen());
                throw new CV_TX_CHException("Chưa Có Công Việc Nguyên Chuyến Hàng của : " + contHangExel.getChuyen());
            }

            CongViec_TaiXe_ContHang congViec_taiXe_contHang = new CongViec_TaiXe_ContHang();
            congViec_taiXe_contHang.setContHang(contHang);
            congViec_taiXe_contHang.setTaiXe(xe.getTaiXe());
            congViec_taiXe_contHang.setLoaiCongViec_chuyenHang(loaiCongViec_chuyenHang);

            CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK = new CongViec_TaiXe_ContHangPK();
            congViec_taiXe_contHangPK.setLoaiCongViec_ChuyenHangId(loaiCongViec_chuyenHang.getId());
            congViec_taiXe_contHangPK.setTaixeid(xe.getId());
            congViec_taiXe_contHangPK.setConthangid(contHang.getId());

            congViec_taiXe_contHang.setId(congViec_taiXe_contHangPK);
            congViecTaiXeContHangRespository.save(congViec_taiXe_contHang);


            LoaiChiHo loaiChiHoHDNang = loaiChiHoRespository.findTop1ByTen("Lấy Cont");
            if(loaiChiHoHDNang == null){

                throw new CV_TX_CHException("Không Tìm Thấy Loại Chi Hộ Lấy Cont");
            }
            LoaiChiHo_ContHang loaiChiHo_contHang_Nang = new LoaiChiHo_ContHang();
            loaiChiHo_contHang_Nang.setLoaiChiHo(loaiChiHoHDNang);
            loaiChiHo_contHang_Nang.setContHang(contHang);
            loaiChiHo_contHang_Nang.setTien(contHangExel.getHoaDonNang());

            LoaiChiHo_ContHangPK loaiChiHo_contHang_NangPK = new LoaiChiHo_ContHangPK();
            loaiChiHo_contHang_NangPK.setIdLoaiChiHo(loaiChiHoHDNang.getId());
            loaiChiHo_contHang_NangPK.setIdConHang(contHang.getId());
            loaiChiHo_contHang_Nang.setId(loaiChiHo_contHang_NangPK);
            loaiChiHoContHangRespository.save(loaiChiHo_contHang_Nang);

            LoaiChiHo loaiChiHoHDha = loaiChiHoRespository.findTop1ByTen("Hạ Cont");
            if(loaiChiHoHDha == null){

                throw new CV_TX_CHException("Không Tìm Thấy Loại Chi Hộ Hạ Cont");
            }
            LoaiChiHo_ContHang loaiChiHo_contHang_Ha = new LoaiChiHo_ContHang();
            loaiChiHo_contHang_Ha.setLoaiChiHo(loaiChiHoHDha);
            loaiChiHo_contHang_Ha.setContHang(contHang);
            loaiChiHo_contHang_Ha.setTien(contHangExel.getHoaDonHa());

            LoaiChiHo_ContHangPK loaiChiHo_contHang_HaPK = new LoaiChiHo_ContHangPK();
            loaiChiHo_contHang_HaPK.setIdLoaiChiHo(loaiChiHoHDha.getId());
            loaiChiHo_contHang_HaPK.setIdConHang(contHang.getId());
            loaiChiHo_contHang_Ha.setId(loaiChiHo_contHang_HaPK);
            loaiChiHoContHangRespository.save(loaiChiHo_contHang_Ha);



        }
    }
}
