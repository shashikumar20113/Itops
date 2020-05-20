/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.lti.itops.ipac.custcatmgmt.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSPCustDecisionTaskTableException;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPCustDecisionTaskTable;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableImpl;
import com.lti.itops.ipac.custcatmgmt.model.impl.TTDPSPCustDecisionTaskTableModelImpl;
import com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSPCustDecisionTaskTablePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the ttdpsp cust decision task table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sunprabh
 * @see TTDPSPCustDecisionTaskTablePersistence
 * @see com.lti.itops.ipac.custcatmgmt.service.persistence.TTDPSPCustDecisionTaskTableUtil
 * @generated
 */
@ProviderType
public class TTDPSPCustDecisionTaskTablePersistenceImpl
	extends BasePersistenceImpl<TTDPSPCustDecisionTaskTable>
	implements TTDPSPCustDecisionTaskTablePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TTDPSPCustDecisionTaskTableUtil} to access the ttdpsp cust decision task table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TTDPSPCustDecisionTaskTableImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentTTDPSPTaskCustomerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentTTDPSPTaskCustomerId",
			new String[] { Long.class.getName() },
			TTDPSPCustDecisionTaskTableModelImpl.PARENTTTDPSPTASKCUSTOMERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERID =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentTTDPSPTaskCustomerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @return the matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId) {
		return findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @return the range of matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end) {
		return findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID;
			finderArgs = new Object[] { parentTTDPSPTaskCustomerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID;
			finderArgs = new Object[] {
					parentTTDPSPTaskCustomerId,
					
					start, end, orderByComparator
				};
		}

		List<TTDPSPCustDecisionTaskTable> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSPCustDecisionTaskTable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : list) {
					if ((parentTTDPSPTaskCustomerId != ttdpspCustDecisionTaskTable.getParentTTDPSPTaskCustomerId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERID_PARENTTTDPSPTASKCUSTOMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDPSPCustDecisionTaskTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTTDPSPTaskCustomerId);

				if (!pagination) {
					list = (List<TTDPSPCustDecisionTaskTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSPCustDecisionTaskTable>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerId_First(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByParentTTDPSPTaskCustomerId_First(parentTTDPSPTaskCustomerId,
				orderByComparator);

		if (ttdpspCustDecisionTaskTable != null) {
			return ttdpspCustDecisionTaskTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentTTDPSPTaskCustomerId=");
		msg.append(parentTTDPSPTaskCustomerId);

		msg.append("}");

		throw new NoSuchTTDPSPCustDecisionTaskTableException(msg.toString());
	}

	/**
	 * Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerId_First(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		List<TTDPSPCustDecisionTaskTable> list = findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerId_Last(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByParentTTDPSPTaskCustomerId_Last(parentTTDPSPTaskCustomerId,
				orderByComparator);

		if (ttdpspCustDecisionTaskTable != null) {
			return ttdpspCustDecisionTaskTable;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentTTDPSPTaskCustomerId=");
		msg.append(parentTTDPSPTaskCustomerId);

		msg.append("}");

		throw new NoSuchTTDPSPCustDecisionTaskTableException(msg.toString());
	}

	/**
	 * Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerId_Last(
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		int count = countByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId);

		if (count == 0) {
			return null;
		}

		List<TTDPSPCustDecisionTaskTable> list = findByParentTTDPSPTaskCustomerId(parentTTDPSPTaskCustomerId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ttdpsp cust decision task tables before and after the current ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param TTDPSPCustDecisionTaskTableId the primary key of the current ttdpsp cust decision task table
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable[] findByParentTTDPSPTaskCustomerId_PrevAndNext(
		long TTDPSPCustDecisionTaskTableId, long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = findByPrimaryKey(TTDPSPCustDecisionTaskTableId);

		Session session = null;

		try {
			session = openSession();

			TTDPSPCustDecisionTaskTable[] array = new TTDPSPCustDecisionTaskTableImpl[3];

			array[0] = getByParentTTDPSPTaskCustomerId_PrevAndNext(session,
					ttdpspCustDecisionTaskTable, parentTTDPSPTaskCustomerId,
					orderByComparator, true);

			array[1] = ttdpspCustDecisionTaskTable;

			array[2] = getByParentTTDPSPTaskCustomerId_PrevAndNext(session,
					ttdpspCustDecisionTaskTable, parentTTDPSPTaskCustomerId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTDPSPCustDecisionTaskTable getByParentTTDPSPTaskCustomerId_PrevAndNext(
		Session session,
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable,
		long parentTTDPSPTaskCustomerId,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

		query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERID_PARENTTTDPSPTASKCUSTOMERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TTDPSPCustDecisionTaskTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentTTDPSPTaskCustomerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttdpspCustDecisionTaskTable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDPSPCustDecisionTaskTable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; from the database.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 */
	@Override
	public void removeByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId) {
		for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : findByParentTTDPSPTaskCustomerId(
				parentTTDPSPTaskCustomerId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ttdpspCustDecisionTaskTable);
		}
	}

	/**
	 * Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @return the number of matching ttdpsp cust decision task tables
	 */
	@Override
	public int countByParentTTDPSPTaskCustomerId(
		long parentTTDPSPTaskCustomerId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERID;

		Object[] finderArgs = new Object[] { parentTTDPSPTaskCustomerId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERID_PARENTTTDPSPTASKCUSTOMERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTTDPSPTaskCustomerId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERID_PARENTTTDPSPTASKCUSTOMERID_2 =
		"ttdpspCustDecisionTaskTable.parentTTDPSPTaskCustomerId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTTDPSPCustDecisionTaskTable",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			TTDPSPCustDecisionTaskTableModelImpl.PARENTTTDPSPTASKCUSTOMERID_COLUMN_BITMASK |
			TTDPSPCustDecisionTaskTableModelImpl.SUBTTDPSPTASKCUSTOMERID_COLUMN_BITMASK |
			TTDPSPCustDecisionTaskTableModelImpl.CONDITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TTDPSPCUSTDECISIONTASKTABLE =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTTDPSPCustDecisionTaskTable",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or throws a {@link NoSuchTTDPSPCustDecisionTaskTableException} if it could not be found.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	 * @param condition the condition
	 * @return the matching ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
				subTTDPSPTaskCustomerId, condition);

		if (ttdpspCustDecisionTaskTable == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("parentTTDPSPTaskCustomerId=");
			msg.append(parentTTDPSPTaskCustomerId);

			msg.append(", subTTDPSPTaskCustomerId=");
			msg.append(subTTDPSPTaskCustomerId);

			msg.append(", condition=");
			msg.append(condition);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTTDPSPCustDecisionTaskTableException(msg.toString());
		}

		return ttdpspCustDecisionTaskTable;
	}

	/**
	 * Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	 * @param condition the condition
	 * @return the matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) {
		return fetchByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
			subTTDPSPTaskCustomerId, condition, true);
	}

	/**
	 * Returns the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	 * @param condition the condition
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] {
				parentTTDPSPTaskCustomerId, subTTDPSPTaskCustomerId, condition
			};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
					finderArgs, this);
		}

		if (result instanceof TTDPSPCustDecisionTaskTable) {
			TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = (TTDPSPCustDecisionTaskTable)result;

			if ((parentTTDPSPTaskCustomerId != ttdpspCustDecisionTaskTable.getParentTTDPSPTaskCustomerId()) ||
					(subTTDPSPTaskCustomerId != ttdpspCustDecisionTaskTable.getSubTTDPSPTaskCustomerId()) ||
					(condition != ttdpspCustDecisionTaskTable.isCondition())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

			query.append(_FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_PARENTTTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_SUBTTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_CONDITION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTTDPSPTaskCustomerId);

				qPos.add(subTTDPSPTaskCustomerId);

				qPos.add(condition);

				List<TTDPSPCustDecisionTaskTable> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TTDPSPCustDecisionTaskTablePersistenceImpl.fetchByTTDPSPCustDecisionTaskTable(long, long, boolean, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = list.get(0);

					result = ttdpspCustDecisionTaskTable;

					cacheResult(ttdpspCustDecisionTaskTable);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TTDPSPCustDecisionTaskTable)result;
		}
	}

	/**
	 * Removes the ttdpsp cust decision task table where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63; from the database.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	 * @param condition the condition
	 * @return the ttdpsp cust decision task table that was removed
	 */
	@Override
	public TTDPSPCustDecisionTaskTable removeByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = findByTTDPSPCustDecisionTaskTable(parentTTDPSPTaskCustomerId,
				subTTDPSPTaskCustomerId, condition);

		return remove(ttdpspCustDecisionTaskTable);
	}

	/**
	 * Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and subTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param subTTDPSPTaskCustomerId the sub ttdpsp task customer ID
	 * @param condition the condition
	 * @return the number of matching ttdpsp cust decision task tables
	 */
	@Override
	public int countByTTDPSPCustDecisionTaskTable(
		long parentTTDPSPTaskCustomerId, long subTTDPSPTaskCustomerId,
		boolean condition) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TTDPSPCUSTDECISIONTASKTABLE;

		Object[] finderArgs = new Object[] {
				parentTTDPSPTaskCustomerId, subTTDPSPTaskCustomerId, condition
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

			query.append(_FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_PARENTTTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_SUBTTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_CONDITION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTTDPSPTaskCustomerId);

				qPos.add(subTTDPSPTaskCustomerId);

				qPos.add(condition);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_PARENTTTDPSPTASKCUSTOMERID_2 =
		"ttdpspCustDecisionTaskTable.parentTTDPSPTaskCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_SUBTTDPSPTASKCUSTOMERID_2 =
		"ttdpspCustDecisionTaskTable.subTTDPSPTaskCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_TTDPSPCUSTDECISIONTASKTABLE_CONDITION_2 =
		"ttdpspCustDecisionTaskTable.condition = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByParentTTDPSPTaskCustomerIdAndCondition",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentTTDPSPTaskCustomerIdAndCondition",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			TTDPSPCustDecisionTaskTableModelImpl.PARENTTTDPSPTASKCUSTOMERID_COLUMN_BITMASK |
			TTDPSPCustDecisionTaskTableModelImpl.CONDITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION =
		new FinderPath(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentTTDPSPTaskCustomerIdAndCondition",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @return the matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition) {
		return findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @return the range of matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end) {
		return findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
			condition, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition, int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION;
			finderArgs = new Object[] { parentTTDPSPTaskCustomerId, condition };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION;
			finderArgs = new Object[] {
					parentTTDPSPTaskCustomerId, condition,
					
					start, end, orderByComparator
				};
		}

		List<TTDPSPCustDecisionTaskTable> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSPCustDecisionTaskTable>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : list) {
					if ((parentTTDPSPTaskCustomerId != ttdpspCustDecisionTaskTable.getParentTTDPSPTaskCustomerId()) ||
							(condition != ttdpspCustDecisionTaskTable.isCondition())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_PARENTTTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_CONDITION_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TTDPSPCustDecisionTaskTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTTDPSPTaskCustomerId);

				qPos.add(condition);

				if (!pagination) {
					list = (List<TTDPSPCustDecisionTaskTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSPCustDecisionTaskTable>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerIdAndCondition_First(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByParentTTDPSPTaskCustomerIdAndCondition_First(parentTTDPSPTaskCustomerId,
				condition, orderByComparator);

		if (ttdpspCustDecisionTaskTable != null) {
			return ttdpspCustDecisionTaskTable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentTTDPSPTaskCustomerId=");
		msg.append(parentTTDPSPTaskCustomerId);

		msg.append(", condition=");
		msg.append(condition);

		msg.append("}");

		throw new NoSuchTTDPSPCustDecisionTaskTableException(msg.toString());
	}

	/**
	 * Returns the first ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerIdAndCondition_First(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		List<TTDPSPCustDecisionTaskTable> list = findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
				condition, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByParentTTDPSPTaskCustomerIdAndCondition_Last(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByParentTTDPSPTaskCustomerIdAndCondition_Last(parentTTDPSPTaskCustomerId,
				condition, orderByComparator);

		if (ttdpspCustDecisionTaskTable != null) {
			return ttdpspCustDecisionTaskTable;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentTTDPSPTaskCustomerId=");
		msg.append(parentTTDPSPTaskCustomerId);

		msg.append(", condition=");
		msg.append(condition);

		msg.append("}");

		throw new NoSuchTTDPSPCustDecisionTaskTableException(msg.toString());
	}

	/**
	 * Returns the last ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ttdpsp cust decision task table, or <code>null</code> if a matching ttdpsp cust decision task table could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByParentTTDPSPTaskCustomerIdAndCondition_Last(
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		int count = countByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
				condition);

		if (count == 0) {
			return null;
		}

		List<TTDPSPCustDecisionTaskTable> list = findByParentTTDPSPTaskCustomerIdAndCondition(parentTTDPSPTaskCustomerId,
				condition, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ttdpsp cust decision task tables before and after the current ttdpsp cust decision task table in the ordered set where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param TTDPSPCustDecisionTaskTableId the primary key of the current ttdpsp cust decision task table
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable[] findByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(
		long TTDPSPCustDecisionTaskTableId, long parentTTDPSPTaskCustomerId,
		boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = findByPrimaryKey(TTDPSPCustDecisionTaskTableId);

		Session session = null;

		try {
			session = openSession();

			TTDPSPCustDecisionTaskTable[] array = new TTDPSPCustDecisionTaskTableImpl[3];

			array[0] = getByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(session,
					ttdpspCustDecisionTaskTable, parentTTDPSPTaskCustomerId,
					condition, orderByComparator, true);

			array[1] = ttdpspCustDecisionTaskTable;

			array[2] = getByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(session,
					ttdpspCustDecisionTaskTable, parentTTDPSPTaskCustomerId,
					condition, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TTDPSPCustDecisionTaskTable getByParentTTDPSPTaskCustomerIdAndCondition_PrevAndNext(
		Session session,
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable,
		long parentTTDPSPTaskCustomerId, boolean condition,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

		query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_PARENTTTDPSPTASKCUSTOMERID_2);

		query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_CONDITION_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TTDPSPCustDecisionTaskTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentTTDPSPTaskCustomerId);

		qPos.add(condition);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ttdpspCustDecisionTaskTable);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TTDPSPCustDecisionTaskTable> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63; from the database.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 */
	@Override
	public void removeByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition) {
		for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : findByParentTTDPSPTaskCustomerIdAndCondition(
				parentTTDPSPTaskCustomerId, condition, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ttdpspCustDecisionTaskTable);
		}
	}

	/**
	 * Returns the number of ttdpsp cust decision task tables where parentTTDPSPTaskCustomerId = &#63; and condition = &#63;.
	 *
	 * @param parentTTDPSPTaskCustomerId the parent ttdpsp task customer ID
	 * @param condition the condition
	 * @return the number of matching ttdpsp cust decision task tables
	 */
	@Override
	public int countByParentTTDPSPTaskCustomerIdAndCondition(
		long parentTTDPSPTaskCustomerId, boolean condition) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION;

		Object[] finderArgs = new Object[] { parentTTDPSPTaskCustomerId, condition };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TTDPSPCUSTDECISIONTASKTABLE_WHERE);

			query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_PARENTTTDPSPTASKCUSTOMERID_2);

			query.append(_FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_CONDITION_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentTTDPSPTaskCustomerId);

				qPos.add(condition);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_PARENTTTDPSPTASKCUSTOMERID_2 =
		"ttdpspCustDecisionTaskTable.parentTTDPSPTaskCustomerId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION_CONDITION_2 =
		"ttdpspCustDecisionTaskTable.condition = ?";

	public TTDPSPCustDecisionTaskTablePersistenceImpl() {
		setModelClass(TTDPSPCustDecisionTaskTable.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("condition", "condition_");
			dbColumnNames.put("order", "order_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the ttdpsp cust decision task table in the entity cache if it is enabled.
	 *
	 * @param ttdpspCustDecisionTaskTable the ttdpsp cust decision task table
	 */
	@Override
	public void cacheResult(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		entityCache.putResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			ttdpspCustDecisionTaskTable.getPrimaryKey(),
			ttdpspCustDecisionTaskTable);

		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
			new Object[] {
				ttdpspCustDecisionTaskTable.getParentTTDPSPTaskCustomerId(),
				ttdpspCustDecisionTaskTable.getSubTTDPSPTaskCustomerId(),
				ttdpspCustDecisionTaskTable.isCondition()
			}, ttdpspCustDecisionTaskTable);

		ttdpspCustDecisionTaskTable.resetOriginalValues();
	}

	/**
	 * Caches the ttdpsp cust decision task tables in the entity cache if it is enabled.
	 *
	 * @param ttdpspCustDecisionTaskTables the ttdpsp cust decision task tables
	 */
	@Override
	public void cacheResult(
		List<TTDPSPCustDecisionTaskTable> ttdpspCustDecisionTaskTables) {
		for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : ttdpspCustDecisionTaskTables) {
			if (entityCache.getResult(
						TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
						TTDPSPCustDecisionTaskTableImpl.class,
						ttdpspCustDecisionTaskTable.getPrimaryKey()) == null) {
				cacheResult(ttdpspCustDecisionTaskTable);
			}
			else {
				ttdpspCustDecisionTaskTable.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ttdpsp cust decision task tables.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TTDPSPCustDecisionTaskTableImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ttdpsp cust decision task table.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		entityCache.removeResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			ttdpspCustDecisionTaskTable.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TTDPSPCustDecisionTaskTableModelImpl)ttdpspCustDecisionTaskTable,
			true);
	}

	@Override
	public void clearCache(
		List<TTDPSPCustDecisionTaskTable> ttdpspCustDecisionTaskTables) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : ttdpspCustDecisionTaskTables) {
			entityCache.removeResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
				TTDPSPCustDecisionTaskTableImpl.class,
				ttdpspCustDecisionTaskTable.getPrimaryKey());

			clearUniqueFindersCache((TTDPSPCustDecisionTaskTableModelImpl)ttdpspCustDecisionTaskTable,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		TTDPSPCustDecisionTaskTableModelImpl ttdpspCustDecisionTaskTableModelImpl) {
		Object[] args = new Object[] {
				ttdpspCustDecisionTaskTableModelImpl.getParentTTDPSPTaskCustomerId(),
				ttdpspCustDecisionTaskTableModelImpl.getSubTTDPSPTaskCustomerId(),
				ttdpspCustDecisionTaskTableModelImpl.isCondition()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_TTDPSPCUSTDECISIONTASKTABLE,
			args, Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
			args, ttdpspCustDecisionTaskTableModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TTDPSPCustDecisionTaskTableModelImpl ttdpspCustDecisionTaskTableModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					ttdpspCustDecisionTaskTableModelImpl.getParentTTDPSPTaskCustomerId(),
					ttdpspCustDecisionTaskTableModelImpl.getSubTTDPSPTaskCustomerId(),
					ttdpspCustDecisionTaskTableModelImpl.isCondition()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSPCUSTDECISIONTASKTABLE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
				args);
		}

		if ((ttdpspCustDecisionTaskTableModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					ttdpspCustDecisionTaskTableModelImpl.getOriginalParentTTDPSPTaskCustomerId(),
					ttdpspCustDecisionTaskTableModelImpl.getOriginalSubTTDPSPTaskCustomerId(),
					ttdpspCustDecisionTaskTableModelImpl.getOriginalCondition()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TTDPSPCUSTDECISIONTASKTABLE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_TTDPSPCUSTDECISIONTASKTABLE,
				args);
		}
	}

	/**
	 * Creates a new ttdpsp cust decision task table with the primary key. Does not add the ttdpsp cust decision task table to the database.
	 *
	 * @param TTDPSPCustDecisionTaskTableId the primary key for the new ttdpsp cust decision task table
	 * @return the new ttdpsp cust decision task table
	 */
	@Override
	public TTDPSPCustDecisionTaskTable create(
		long TTDPSPCustDecisionTaskTableId) {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = new TTDPSPCustDecisionTaskTableImpl();

		ttdpspCustDecisionTaskTable.setNew(true);
		ttdpspCustDecisionTaskTable.setPrimaryKey(TTDPSPCustDecisionTaskTableId);

		return ttdpspCustDecisionTaskTable;
	}

	/**
	 * Removes the ttdpsp cust decision task table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	 * @return the ttdpsp cust decision task table that was removed
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable remove(
		long TTDPSPCustDecisionTaskTableId)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		return remove((Serializable)TTDPSPCustDecisionTaskTableId);
	}

	/**
	 * Removes the ttdpsp cust decision task table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ttdpsp cust decision task table
	 * @return the ttdpsp cust decision task table that was removed
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable remove(Serializable primaryKey)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		Session session = null;

		try {
			session = openSession();

			TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = (TTDPSPCustDecisionTaskTable)session.get(TTDPSPCustDecisionTaskTableImpl.class,
					primaryKey);

			if (ttdpspCustDecisionTaskTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTTDPSPCustDecisionTaskTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ttdpspCustDecisionTaskTable);
		}
		catch (NoSuchTTDPSPCustDecisionTaskTableException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TTDPSPCustDecisionTaskTable removeImpl(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ttdpspCustDecisionTaskTable)) {
				ttdpspCustDecisionTaskTable = (TTDPSPCustDecisionTaskTable)session.get(TTDPSPCustDecisionTaskTableImpl.class,
						ttdpspCustDecisionTaskTable.getPrimaryKeyObj());
			}

			if (ttdpspCustDecisionTaskTable != null) {
				session.delete(ttdpspCustDecisionTaskTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ttdpspCustDecisionTaskTable != null) {
			clearCache(ttdpspCustDecisionTaskTable);
		}

		return ttdpspCustDecisionTaskTable;
	}

	@Override
	public TTDPSPCustDecisionTaskTable updateImpl(
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable) {
		boolean isNew = ttdpspCustDecisionTaskTable.isNew();

		if (!(ttdpspCustDecisionTaskTable instanceof TTDPSPCustDecisionTaskTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ttdpspCustDecisionTaskTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ttdpspCustDecisionTaskTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ttdpspCustDecisionTaskTable proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TTDPSPCustDecisionTaskTable implementation " +
				ttdpspCustDecisionTaskTable.getClass());
		}

		TTDPSPCustDecisionTaskTableModelImpl ttdpspCustDecisionTaskTableModelImpl =
			(TTDPSPCustDecisionTaskTableModelImpl)ttdpspCustDecisionTaskTable;

		Session session = null;

		try {
			session = openSession();

			if (ttdpspCustDecisionTaskTable.isNew()) {
				session.save(ttdpspCustDecisionTaskTable);

				ttdpspCustDecisionTaskTable.setNew(false);
			}
			else {
				ttdpspCustDecisionTaskTable = (TTDPSPCustDecisionTaskTable)session.merge(ttdpspCustDecisionTaskTable);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TTDPSPCustDecisionTaskTableModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					ttdpspCustDecisionTaskTableModelImpl.getParentTTDPSPTaskCustomerId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID,
				args);

			args = new Object[] {
					ttdpspCustDecisionTaskTableModelImpl.getParentTTDPSPTaskCustomerId(),
					ttdpspCustDecisionTaskTableModelImpl.isCondition()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((ttdpspCustDecisionTaskTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttdpspCustDecisionTaskTableModelImpl.getOriginalParentTTDPSPTaskCustomerId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID,
					args);

				args = new Object[] {
						ttdpspCustDecisionTaskTableModelImpl.getParentTTDPSPTaskCustomerId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERID,
					args);
			}

			if ((ttdpspCustDecisionTaskTableModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ttdpspCustDecisionTaskTableModelImpl.getOriginalParentTTDPSPTaskCustomerId(),
						ttdpspCustDecisionTaskTableModelImpl.getOriginalCondition()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION,
					args);

				args = new Object[] {
						ttdpspCustDecisionTaskTableModelImpl.getParentTTDPSPTaskCustomerId(),
						ttdpspCustDecisionTaskTableModelImpl.isCondition()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTTTDPSPTASKCUSTOMERIDANDCONDITION,
					args);
			}
		}

		entityCache.putResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
			TTDPSPCustDecisionTaskTableImpl.class,
			ttdpspCustDecisionTaskTable.getPrimaryKey(),
			ttdpspCustDecisionTaskTable, false);

		clearUniqueFindersCache(ttdpspCustDecisionTaskTableModelImpl, false);
		cacheUniqueFindersCache(ttdpspCustDecisionTaskTableModelImpl);

		ttdpspCustDecisionTaskTable.resetOriginalValues();

		return ttdpspCustDecisionTaskTable;
	}

	/**
	 * Returns the ttdpsp cust decision task table with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttdpsp cust decision task table
	 * @return the ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByPrimaryKey(primaryKey);

		if (ttdpspCustDecisionTaskTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTTDPSPCustDecisionTaskTableException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ttdpspCustDecisionTaskTable;
	}

	/**
	 * Returns the ttdpsp cust decision task table with the primary key or throws a {@link NoSuchTTDPSPCustDecisionTaskTableException} if it could not be found.
	 *
	 * @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	 * @return the ttdpsp cust decision task table
	 * @throws NoSuchTTDPSPCustDecisionTaskTableException if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable findByPrimaryKey(
		long TTDPSPCustDecisionTaskTableId)
		throws NoSuchTTDPSPCustDecisionTaskTableException {
		return findByPrimaryKey((Serializable)TTDPSPCustDecisionTaskTableId);
	}

	/**
	 * Returns the ttdpsp cust decision task table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ttdpsp cust decision task table
	 * @return the ttdpsp cust decision task table, or <code>null</code> if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByPrimaryKey(
		Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
				TTDPSPCustDecisionTaskTableImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = (TTDPSPCustDecisionTaskTable)serializable;

		if (ttdpspCustDecisionTaskTable == null) {
			Session session = null;

			try {
				session = openSession();

				ttdpspCustDecisionTaskTable = (TTDPSPCustDecisionTaskTable)session.get(TTDPSPCustDecisionTaskTableImpl.class,
						primaryKey);

				if (ttdpspCustDecisionTaskTable != null) {
					cacheResult(ttdpspCustDecisionTaskTable);
				}
				else {
					entityCache.putResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
						TTDPSPCustDecisionTaskTableImpl.class, primaryKey,
						nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSPCustDecisionTaskTableImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ttdpspCustDecisionTaskTable;
	}

	/**
	 * Returns the ttdpsp cust decision task table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param TTDPSPCustDecisionTaskTableId the primary key of the ttdpsp cust decision task table
	 * @return the ttdpsp cust decision task table, or <code>null</code> if a ttdpsp cust decision task table with the primary key could not be found
	 */
	@Override
	public TTDPSPCustDecisionTaskTable fetchByPrimaryKey(
		long TTDPSPCustDecisionTaskTableId) {
		return fetchByPrimaryKey((Serializable)TTDPSPCustDecisionTaskTableId);
	}

	@Override
	public Map<Serializable, TTDPSPCustDecisionTaskTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TTDPSPCustDecisionTaskTable> map = new HashMap<Serializable, TTDPSPCustDecisionTaskTable>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable = fetchByPrimaryKey(primaryKey);

			if (ttdpspCustDecisionTaskTable != null) {
				map.put(primaryKey, ttdpspCustDecisionTaskTable);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSPCustDecisionTaskTableImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey,
						(TTDPSPCustDecisionTaskTable)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : (List<TTDPSPCustDecisionTaskTable>)q.list()) {
				map.put(ttdpspCustDecisionTaskTable.getPrimaryKeyObj(),
					ttdpspCustDecisionTaskTable);

				cacheResult(ttdpspCustDecisionTaskTable);

				uncachedPrimaryKeys.remove(ttdpspCustDecisionTaskTable.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TTDPSPCustDecisionTaskTableModelImpl.ENTITY_CACHE_ENABLED,
					TTDPSPCustDecisionTaskTableImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the ttdpsp cust decision task tables.
	 *
	 * @return the ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ttdpsp cust decision task tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @return the range of ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ttdpsp cust decision task tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findAll(int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ttdpsp cust decision task tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TTDPSPCustDecisionTaskTableModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ttdpsp cust decision task tables
	 * @param end the upper bound of the range of ttdpsp cust decision task tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ttdpsp cust decision task tables
	 */
	@Override
	public List<TTDPSPCustDecisionTaskTable> findAll(int start, int end,
		OrderByComparator<TTDPSPCustDecisionTaskTable> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TTDPSPCustDecisionTaskTable> list = null;

		if (retrieveFromCache) {
			list = (List<TTDPSPCustDecisionTaskTable>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE;

				if (pagination) {
					sql = sql.concat(TTDPSPCustDecisionTaskTableModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TTDPSPCustDecisionTaskTable>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TTDPSPCustDecisionTaskTable>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ttdpsp cust decision task tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable : findAll()) {
			remove(ttdpspCustDecisionTaskTable);
		}
	}

	/**
	 * Returns the number of ttdpsp cust decision task tables.
	 *
	 * @return the number of ttdpsp cust decision task tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TTDPSPCUSTDECISIONTASKTABLE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TTDPSPCustDecisionTaskTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ttdpsp cust decision task table persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TTDPSPCustDecisionTaskTableImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE = "SELECT ttdpspCustDecisionTaskTable FROM TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable";
	private static final String _SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE_PKS_IN =
		"SELECT ttdpspCustDecisionTaskTable FROM TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable WHERE TTDPSPCustDecisionTaskTableId IN (";
	private static final String _SQL_SELECT_TTDPSPCUSTDECISIONTASKTABLE_WHERE = "SELECT ttdpspCustDecisionTaskTable FROM TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable WHERE ";
	private static final String _SQL_COUNT_TTDPSPCUSTDECISIONTASKTABLE = "SELECT COUNT(ttdpspCustDecisionTaskTable) FROM TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable";
	private static final String _SQL_COUNT_TTDPSPCUSTDECISIONTASKTABLE_WHERE = "SELECT COUNT(ttdpspCustDecisionTaskTable) FROM TTDPSPCustDecisionTaskTable ttdpspCustDecisionTaskTable WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ttdpspCustDecisionTaskTable.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TTDPSPCustDecisionTaskTable exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TTDPSPCustDecisionTaskTable exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TTDPSPCustDecisionTaskTablePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"condition", "order"
			});
}