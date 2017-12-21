package pl.com.booker.injection.modules


import com.momedia.cargo.ui.complaints.ComplaintsMvvm
import com.momedia.cargo.ui.complaints.ComplaintsViewModel
import com.momedia.cargo.ui.dashboard.DashboardMvvm
import com.momedia.cargo.ui.dashboard.DashboardViewModel
import com.momedia.cargo.ui.dashboard.viewpager.DashboardViewPagerFragmentMvvm
import com.momedia.cargo.ui.dashboard.viewpager.DashboardViewPagerFragmentViewModel
import com.momedia.cargo.ui.history.HistoryMvvm
import com.momedia.cargo.ui.history.HistoryViewModel
import com.momedia.cargo.ui.login.LoginPartnerMvvm
import com.momedia.cargo.ui.login.LoginPartnerViewModel
import com.momedia.cargo.ui.main.MainMvvm
import com.momedia.cargo.ui.main.MainViewModel
import com.momedia.cargo.ui.mydata.MyDataMvvm
import com.momedia.cargo.ui.mydata.MyDataViewModel
import com.momedia.cargo.ui.mydata.section_mydata.MyDataActivityMvvm
import com.momedia.cargo.ui.mydata.section_mydata.MyDataActivityViewModel
import com.momedia.cargo.ui.new_order.NewOrderMvvm
import com.momedia.cargo.ui.new_order.NewOrderViewModel
import com.momedia.cargo.ui.new_order.summary.OrderSummaryMvvm
import com.momedia.cargo.ui.new_order.summary.OrderSummaryViewModel
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelModule {

    /*@Binds
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): MainMvvm.ViewModel
*/

}