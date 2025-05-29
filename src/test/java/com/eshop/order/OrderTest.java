package com.eshop.order;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eshop.entity.order.TbOrder;
import com.eshop.entity.order.TbOrderBillDetail;
import com.eshop.entity.order.TbOrderCostDetail;
import com.eshop.service.order.ITbOrderBillDetailService;
import com.eshop.service.order.ITbOrderCostDetailService;
import com.eshop.service.order.ITbOrderService;
import com.google.common.collect.ImmutableSet;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@SpringBootTest
public class OrderTest {

    public static final Set<String> orderNos = ImmutableSet.of(
            "PO-211-19915355904634062",
            "PO-211-19349717842550747",
            "PO-211-19770002125433104",
            "PO-211-19261861304950023",
            "PO-211-19839103580793460",
            "PO-211-19509676739191616",
            "PO-211-19426584167031057",
            "PO-211-19805594317433404",
            "PO-211-19847501558393698",
            "PO-211-19771215309433131",
            "PO-211-19862721423993609",
            "PO-211-19595495967352128",
            "PO-211-19609957427832298",
            "PO-211-19736896492153047",
            "PO-211-19644989880952315",
            "PO-211-19291494799990324",
            "PO-211-19774888090233077",
            "PO-211-19512508140151569",
            "PO-211-19844946350713683",
            "PO-211-19734892780152835",
            "PO-211-19719274117752894",
            "PO-211-19467848632951323",
            "PO-211-19458107546231381",
            "PO-211-19873031322233802",
            "PO-211-19534810133111722",
            "PO-211-19536246856311715",
            "PO-211-19803412255353451",
            "PO-211-19780969042553297",
            "PO-211-19260530494070031",
            "PO-211-19593493054072140",
            "PO-211-19547955395191868",
            "PO-211-19593881641592138",
            "PO-211-19514617436791586",
            "PO-211-19319726920310444",
            "PON2505203162038235",
            "PON2505203162033622",
            "PON2505203162163256",
            "PON2505203162034812",
            "PON2505203162163257",
            "PON2505203162033626",
            "PON2505203162033624",
            "PON2505203162033620",
            "PON2505203162005646",
            "PON2505203162005643",
            "PON2505203162311012",
            "PON2505203162306699",
            "PON2505203162094657",
            "PON2505203161986422",
            "PON2505203162152898",
            "PO-211-00245161841271499",
            "PO-211-00069891502710462",
            "PO-211-00273564795511584",
            "PO-211-00631341302393805",
            "PO-211-00531377203833121",
            "PONY2505203625905067",
            "WB2505211240487",
            "WB2505211496022",
            "PONY2505223630677058",
            "WB2505223391233",
            "PONY2505233632488894",
            "PON2505233163535690",
            "PON2505233163477693",
            "PON2505233163535696",
            "PON2505233163477696",
            "PON2505233163535693",
            "PON2505233163396285",
            "PON2505233163477692",
            "PON2505233163356075",
            "PON2505233163396284",
            "PON2505233163396278",
            "PON2505233163356076",
            "PON2505233163184841",
            "PON2505233163356070",
            "PON2505233163158858",
            "PON2505233163184832",
            "PON2505233163571055",
            "PON2505233163521231",
            "PON2505233163395268",
            "PON2505233163349267",
            "PON2505233163571059",
            "PON2505233163349265",
            "PONY2505233633242269",
            "PONY2505243634305877",
            "WB250524883106",
            "PONY2505243634901441",
            "PONY2505243634789059",
            "PONY2505243635854691",
            "PONY2505243635909296",
            "PONY2505243635895090",
            "PONY2505243635903057",
            "WB2505251322555",
            "PONY2505253636974044",
            "PONY2505253636985055",
            "PONY2505253636987406",
            "PONY2505263638974459",
            "PONY2505263638992223",
            "WB2505271861746",
            "PON2505273164960034",
            "PON2505273164960035",
            "PON2505273164859500",
            "PON2505273164872801",
            "PON2505273164960036",
            "PON2505273164859499",
            "PON2505273164825866",
            "PON2505273164859484",
            "PON2505273164766879",
            "PON2505273164825869",
            "PON2505273164766881",
            "PON2505273164766853",
            "PON2505273164577854",
            "PON2505273164963441",
            "PON2505273164858819",
            "PON2505273164885031",
            "PON2505273164963443",
            "PON2505273164885033",
            "PON2505273164853872",
            "PON2505273164827630",
            "PON2505273164696058",
            "PON2505273164827632",
            "PON2505273164696057",
            "PON2505273164627489",
            "PON2505273164696056",
            "WB2505281011658",
            "WB2505284410923",
            "578915129502303407",
            "578903230602053578",
            "578896798875354738",
            "578855822986479425",
            "579029121754104943",
            "579029106500994466",
            "579029192733787410",
            "579029100114052924",
            "579029196311922168",
            "579029175750919412",
            "579029169059562756",
            "579029109875508757",
            "579029171279005190",
            "579029128098186935",
            "579029096441480448",
            "579029145979160390",
            "579029108148242296",
            "579029109081539669",
            "579029176967988992",
            "579029124773151910",
            "579029110064842114",
            "579029204261963309",
            "579029279316018797",
            "579029270328870170",
            "579029230318552346",
            "579029273142133897",
            "579029217042400402",
            "579029274580846546",
            "579029227801314593",
            "579029290936009800",
            "579029375356339661",
            "579029484608390861",
            "579029471939364127",
            "579029428803503444",
            "579029403807548998",
            "579029375356405197",
            "579029320516470306",
            "579029317685576997",
            "579029481231714230",
            "579029357248415736",
            "579029403956643336",
            "579029493626995848",
            "579029463183557642",
            "579029477571986796",
            "579029424621979442",
            "579029307678557497",
            "579029358102153019",
            "579029496551605564",
            "579029495065774017",
            "579029365991376831",
            "579029349650957633",
            "579029350742722495",
            "579029431669524425",
            "579029346724841121",
            "WB2505291636111",
            "579029515682612646",
            "579029657299552057",
            "579029730020984186",
            "579029792534529711",
            "579029767121175579",
            "579029684401440476",
            "579029505328055798",
            "579029513792554911",
            "579029623198352631",
            "579029548831573779",
            "579029592208148165",
            "579029766268880368",
            "579029725936256437",
            "579029509837063575",
            "579029694824219719",
            "579029624823187134",
            "579029774031685587",
            "579029741019760196",
            "579029656147888030",
            "579029548831639315",
            "579029642450863550",
            "579029631617107308",
            "579029809082631952",
            "579029725364323902",
            "579029789681813260",
            "579029721534727924",
            "579029606432998422",
            "579029667257550485",
            "579029795672917170",
            "579029614292666236",
            "579029506898298172",
            "579029743714600417",
            "579029754855917017",
            "579029784802985383",
            "579029549319292760",
            "579029750713976017",
            "579029801356657698",
            "579029629904324082",
            "579030282598450208",
            "579030086535382038",
            "579029998582662908",
            "579030123676075524",
            "579030185234367584",
            "579030189313852950",
            "579029966940636905",
            "579030015173560096",
            "579029970412930271",
            "579029873267017177",
            "579029798550079422",
            "579030162892752833",
            "579030217966126844",
            "579030162754537150",
            "579030242692859097",
            "579029952744359699",
            "579030177913669432",
            "579030229977171020",
            "579029946766296608",
            "579030034172577594",
            "579030025724789901",
            "579029976605230472",
            "579030093380355262",
            "579029902361790307",
            "579029948275263157",
            "579030104000464492",
            "579030044480800009",
            "579029807195260030",
            "579029916705326374",
            "579030015137842288",
            "579030054364021822",
            "579030008750834750",
            "579030038081602948",
            "579029921198539935",
            "579030038420096307",
            "579030239839880318",
            "579030021057381883",
            "579030207438816930",
            "579030013466674391",
            "579030263407871315",
            "579030017443136608",
            "579030003916965707",
            "579030196567311753",
            "579029900394464738",
            "579030207404934148",
            "579030248725514232",
            "579030213151852360",
            "579030060288673500",
            "579030166505097153",
            "579030157105203083",
            "579029951985911482",
            "579030057823470641",
            "579029975221831354",
            "579030057180694367",
            "579029985228457658",
            "579030002840011814",
            "PONY2505293646344415",
            "579030755103180544",
            "579030660553213474",
            "579030467028289412",
            "579030616694162802",
            "579030485465139104",
            "579030457877825440",
            "579030379712186052",
            "579030271839536424",
            "579030756442343003",
            "579030340829676928",
            "579030571259758361",
            "579030369170720698",
            "579030427488584929",
            "579030726203312058",
            "579030301284140542",
            "579030740589642856",
            "579030243434267724",
            "579030506744547105",
            "579030252267734061",
            "579030366895244564",
            "579030323527190507",
            "579030320401253448",
            "579030285718095110",
            "579030481164076958",
            "579030665911043703",
            "579030301321365053",
            "579030418906384165",
            "579030342204294330",
            "579030255764735342",
            "579030548191413339",
            "579030583626401421",
            "579030443539006771",
            "579030392433903441",
            "579030426154337719",
            "579030337766392999",
            "579030610882234020",
            "579030740258358793",
            "579030627559638619",
            "579030086750602395",
            "579030451102974997",
            "579030579590890641",
            "579030539793630252",
            "579030393248384421",
            "579030535980746731",
            "579030732375688530",
            "579030622342055306",
            "579030591810208884",
            "579030634060809983",
            "579030533384537233",
            "579030510291223697",
            "579030472257996737",
            "579030430433118168",
            "579030386098276077",
            "579030389415511742",
            "579030372315071598",
            "579030354971559656",
            "579030574549861454",
            "579030477770294309",
            "579030463715509270"
    );

    @Resource
    private ITbOrderService iTbOrderService;

    @Resource
    private ITbOrderBillDetailService iTbOrderBillDetailService;


    @Resource
    private ITbOrderCostDetailService iTbOrderCostDetailService;


    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Resource
    private FxRateCnyUtils fxRateCnyUtils;

    public List<TbOrder> getOrderList(Set<String> orderNos) {
        if (orderNos == null || orderNos.isEmpty()) {
            return Collections.emptyList();
        }

        // 设置批次大小
        int batchSize = 500;
        // 将Set转为List以支持分批
        List<String> orderNoList = new ArrayList<>(orderNos);
        // 计算需要查询的批次数
        int batchCount = (int) Math.ceil((double) orderNoList.size() / batchSize);

        // 创建异步任务列表
        List<CompletableFuture<List<TbOrder>>> futures = new ArrayList<>();

        // 分批异步查询
        for (int i = 0; i < batchCount; i++) {
            int startIndex = i * batchSize;
            int endIndex = Math.min((i + 1) * batchSize, orderNoList.size());

            // 获取当前批次的订单号
            List<String> batchOrderNos = orderNoList.subList(startIndex, endIndex);

            CompletableFuture<List<TbOrder>> future = CompletableFuture.supplyAsync(() -> {
                LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.in(TbOrder::getOrderNo, batchOrderNos);
                return iTbOrderService.list(queryWrapper);
            }, excelTaskPool);

            futures.add(future);
        }

        // 等待所有异步任务完成并合并结果
        return futures.stream()
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Test
    void init() throws Exception {
        List<TbOrder> orderList = getOrder();
        List<String> orderNoList = orderList.stream().map(TbOrder::getOrderNo).collect(Collectors.toList());
        Map<String, TbOrderCostDetail> orderCostDetailMap = getStringTbOrderCostDetailMap(orderNoList);
        Map<String, TbOrderBillDetail> stringTbOrderCostDetailMap2 = getStringTbOrderCostDetailMap2(orderNoList);
        List<TbOrderBillDetail> addlist = new ArrayList<>();
        for (TbOrder order : orderList) {
            if (stringTbOrderCostDetailMap2.containsKey(order.getOrderNo())) {
                continue;
            }

            String currency = Optional.ofNullable(orderCostDetailMap)
                    .map(p->p.get(order.getOrderNo()))
                    .map(pi->pi.getCurrency())
                    .orElse("");
            if (StringUtils.isBlank(currency)) {
                continue;
            }
            TbOrderBillDetail tbOrderBillDetail = saveObd(order.getId(), order.getOrderNo(), currency, order.getPaymentTime());
            addlist.add(tbOrderBillDetail);
        }

        if (CollectionUtils.isNotEmpty(addlist)) {
            System.out.println(JSON.toJSON(addlist));
            iTbOrderBillDetailService.saveBatch(addlist);
        }
    }
    private List<TbOrder> getOrder(){
        LambdaQueryWrapper<TbOrder> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(TbOrder::getOrderTime, "2025-05-29 00:00:00");
        return iTbOrderService.list(queryWrapper);
    }
    @NotNull
    private Map<String, TbOrderCostDetail> getStringTbOrderCostDetailMap(List<String> orderNoList) {
        LambdaQueryWrapper<TbOrderCostDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(TbOrderCostDetail::getOrderNo, orderNoList);
        List<TbOrderCostDetail> orderCostDetails = iTbOrderCostDetailService.list(queryWrapper);
        if (CollectionUtils.isEmpty(orderCostDetails)) {
            return Collections.emptyMap();
        }
        //订单费用map
        Map<String, TbOrderCostDetail> orderCostDetailMap = orderCostDetails.stream().collect(Collectors.toMap(TbOrderCostDetail::getOrderNo, p -> p, (oldValue, newValue) -> newValue));
        return orderCostDetailMap;
    }

    @NotNull
    private Map<String, TbOrderBillDetail> getStringTbOrderCostDetailMap2(List<String> orderNoList) {
        LambdaQueryWrapper<TbOrderBillDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(TbOrderBillDetail::getOrderNo, orderNoList);
        List<TbOrderBillDetail> orderCostDetails = iTbOrderBillDetailService.list(queryWrapper);
        if (CollectionUtils.isEmpty(orderCostDetails)) {
            return Collections.emptyMap();
        }
        //订单费用map
        Map<String, TbOrderBillDetail> orderCostDetailMap = orderCostDetails.stream().collect(Collectors.toMap(TbOrderBillDetail::getOrderNo, p -> p, (oldValue, newValue) -> newValue));
        return orderCostDetailMap;
    }

    private TbOrderBillDetail saveObd(Long orderId, String orderNo, String currencyCode, Date paymentTime) {

        TbOrderBillDetail tbOrderBillDetail = initObd(orderId, orderNo, currencyCode, paymentTime);
        return tbOrderBillDetail;
//        iTbOrderBillDetailService.save(tbOrderBillDetail);
    }

    private TbOrderBillDetail initObd(Long orderId, String orderNo, String currencyCode, Date paymentTime) {
        BigDecimal fxRateCny = null;
        if (StringUtils.isNotBlank(currencyCode)) {
            fxRateCny = fxRateCnyUtils.getFxRateCny(currencyCode, paymentTime);
        } else {
            fxRateCny = BigDecimal.ONE;
            currencyCode = "CNY";
        }

        TbOrderBillDetail addOb = new TbOrderBillDetail();
        //order_id
        addOb.setOrderId(orderId);
        //order_no
        addOb.setOrderNo(orderNo);
        //currency_code
        addOb.setCurrencyCode(currencyCode);
        //order_amount 订单金额
        addOb.setOrderAmount(BigDecimal.ZERO);
        //settlement_amount 订单结算金额
        addOb.setSettlementAmount(BigDecimal.ZERO);
        //buyer_payment 买方付款金额
        addOb.setBuyerPayment(BigDecimal.ZERO);
        //product_total_price 商品总售价
        addOb.setProductTotalPrice(BigDecimal.ZERO);
        //shipping_subtotal 运费小计(可能存在负数)
        addOb.setShippingSubtotal(BigDecimal.ZERO);
        //platform_total_fees 平台总费用
        addOb.setPlatformTotalFees(BigDecimal.ZERO);
        //fx_rate_cny 汇率
        addOb.setFxRateCny(fxRateCny);
        //payment_time 付款时间
        addOb.setPaymentTime(paymentTime);

        // 商品总成本(固定CNY)
        addOb.setProductTotalCost(BigDecimal.ZERO);
        //shipping_cost  线下物流运费(固定CNY)
        addOb.setShippingCost(BigDecimal.ZERO);
        //depot_service_cost	仓库服务费(固定CNY)
        addOb.setDepotServiceCost(BigDecimal.ZERO);

        return addOb;
    }

    public static void main(String[] args) {

        for (String orderNo : orderNos) {
            System.out.println(orderNo);
        }
    }
}
