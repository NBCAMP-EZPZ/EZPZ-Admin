package com.sparta.ezpzadmin.domain.popup.repository.popup;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.ezpzadmin.common.util.PageUtil;
import com.sparta.ezpzadmin.domain.popup.entity.Popup;
import com.sparta.ezpzadmin.domain.popup.enums.ApprovalStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;
import java.util.Objects;

import static com.sparta.ezpzadmin.domain.popup.entity.QPopup.popup;

@RequiredArgsConstructor
public class PopupRepositoryCustomImpl implements PopupRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Popup> findAllPopupsByStatus(PageUtil pageUtil) {
        JPAQuery<Popup> query = findAllPopupsByStatusQuery(popup, pageUtil)
                .offset(pageUtil.toPageable().getOffset())
                .limit(pageUtil.toPageable().getPageSize())
                .orderBy(popup.createdAt.desc());

        List<Popup> popups = query.fetch();
        Long totalSize = countQuery(pageUtil).fetch().get(0);

        return PageableExecutionUtils.getPage(popups, pageUtil.toPageable(), () -> totalSize);
    }

    private <T> JPAQuery<T> findAllPopupsByStatusQuery(Expression<T> expr, PageUtil pageUtil) {
        return jpaQueryFactory.select(expr)
                .from(popup)
                .where(
                        approvalStatusEq(pageUtil.getFirstStatus())
                );
    }

    private JPAQuery<Long> countQuery(PageUtil pageUtil) {
        return jpaQueryFactory.select(Wildcard.count)
                .from(popup)
                .where(
                        approvalStatusEq(pageUtil.getFirstStatus())
                );
    }

    private BooleanExpression approvalStatusEq(String statusBy) {
        return Objects.nonNull(statusBy) && !"all".equals(statusBy) ?
                popup.approvalStatus.eq(ApprovalStatus.valueOf(statusBy.toUpperCase())) : null;
    }
}